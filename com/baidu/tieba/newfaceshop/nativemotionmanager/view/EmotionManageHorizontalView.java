package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.voice.h;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    private View him;
    private NewFaceGroupDownloadModel iUr;
    private EmotionPackageData iYv;
    private HListView iZq;
    private View lDP;
    private TextView lDQ;
    private View lDR;
    private TextView lDS;
    private ImageView lDT;
    private View lDU;
    private a lDV;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private TextView mTitle;
    private ViewGroup rootView;

    public EmotionManageHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.rootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_manage_grid_item_layout, this);
        this.iZq = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.him = this.rootView.findViewById(R.id.emotion_manage_item_line);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.lDP = this.rootView.findViewById(R.id.emotion_manage_item_undownload_header);
        this.lDP.setVisibility(8);
        this.lDQ = (TextView) this.rootView.findViewById(R.id.emotion_manage_undownload_total_title);
        this.lDR = this.rootView.findViewById(R.id.emotion_manage_item_grid_cover);
        this.lDR.setVisibility(8);
        this.lDS = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lDS.setVisibility(8);
        this.lDS.setOnClickListener(this);
        this.lDT = (ImageView) this.rootView.findViewById(R.id.emotion_manage_del);
        this.lDT.setVisibility(8);
        this.lDT.setOnClickListener(this);
        this.lDU = this.rootView.findViewById(R.id.emotion_manage_del_container);
        this.lDU.setOnClickListener(this);
        setOnClickListener(this);
        this.iZq.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZq.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionManageHorizontalView.this.iYv != null) {
                    EmotionManageHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), EmotionManageHorizontalView.this.iYv.id, 0)));
                }
            }
        });
        this.iZq.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lDV = new a(this.mPageContext);
        this.iZq.setAdapter((ListAdapter) this.lDV);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public HListView getListView() {
        return this.iZq;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.him != null) {
            ap.setBackgroundColor(this.him, R.color.CAM_X0204, i);
        }
        if (this.lDP != null) {
            ap.setBackgroundColor(this.lDP, R.color.CAM_X0204, i);
        }
        if (this.mTitle != null) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lDQ != null) {
            ap.setViewTextColor(this.lDQ, R.color.CAM_X0107, i);
        }
        if (this.lDS != null) {
            ap.setViewTextColor(this.lDS, R.color.CAM_X0302, i);
            ap.setBackgroundResource(this.lDS, R.drawable.bg_emotion_download, i);
        }
        if (this.lDT != null) {
            ap.setImageResource(this.lDT, R.drawable.emotion_manage_del_selector, i);
        }
        if (this.lDR != null) {
            ap.setViewTextColor(this.lDR, R.color.white_alpha70, i);
        }
    }

    private void a(EmotionPackageData emotionPackageData, int i) {
        if (emotionPackageData != null) {
            if (emotionPackageData.isUndownloadheader) {
                this.lDP.setVisibility(0);
                this.lDQ.setText(String.format(h.getString(R.string.emotion_manage_net_number), Integer.valueOf(i)));
            } else {
                this.lDP.setVisibility(8);
            }
            djn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djm() {
        if (this.lDS != null) {
            this.lDS.setText(R.string.emotion_single_thread_downloaded);
            ap.setViewTextColor(this.lDS, R.color.CAM_X0109);
            this.lDS.setBackgroundDrawable(null);
            this.lDS.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djn() {
        if (this.lDS != null) {
            this.lDS.setText(R.string.emotion_manage_download);
            ap.setViewTextColor(this.lDS, R.color.CAM_X0302);
            ap.setBackgroundResource(this.lDS, R.drawable.bg_emotion_download);
            this.lDS.setEnabled(true);
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        this.iYv = emotionPackageData;
        if (this.iYv != null) {
            this.lDV.setData(this.iYv.pics, emotionPackageData.typeofemotion);
            this.mTitle.setText(this.iYv.name);
            if (emotionPackageData.ishasdownload) {
                this.lDR.setVisibility(8);
                this.lDS.setVisibility(8);
                if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.diY().bLc()) {
                    this.lDT.setVisibility(0);
                } else {
                    this.lDT.setVisibility(8);
                }
            } else {
                this.lDT.setVisibility(8);
                this.lDS.setVisibility(0);
                this.lDR.setVisibility(0);
            }
            a(emotionPackageData, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iYv != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cyI();
            } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.lDT.isShown()) {
                if (this.iYv != null) {
                    showDialog(this.iYv.id);
                }
            } else {
                djo();
            }
        }
    }

    private void showDialog(final int i) {
        if (this.mPageContext != null) {
            String string = h.getString(R.string.emotion_manage_dialog_title);
            String string2 = h.getString(R.string.emotion_manage_dialog_ok);
            String string3 = h.getString(R.string.emotion_manage_dialog_cancel);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Au(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_MY_EMOTION_PACKAGE, Integer.valueOf(i)));
                }
            });
            aVar.b(string3, new a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
            aVar.b(this.mPageContext).bqx();
        }
    }

    private void djo() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iYv.id, 0)));
    }

    private void cyI() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.diw().diz()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && this.iYv != null && this.iYv.id >= 0) {
                if (this.iUr == null) {
                    this.iUr = new NewFaceGroupDownloadModel();
                }
                this.lDS.setEnabled(false);
                this.iUr.a(Integer.toString(this.iYv.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.5
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        EmotionManageHorizontalView.this.djm();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onProgress(int i) {
                        if (i > 0 && i < 100) {
                            l.showLongToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), h.getString(R.string.package_downloading_progress));
                        } else if (i >= 100) {
                            l.showLongToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        }
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onFail(String str) {
                        l.showToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.download_error);
                        EmotionManageHorizontalView.this.djn();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eUY;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private int lDX = 0;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eUY = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (!y.isEmpty(list)) {
                this.lDX = i;
                this.mDatas.clear();
                if (list.size() > 8) {
                    this.mDatas.addAll(list.subList(0, 8));
                    this.showCover = true;
                } else {
                    this.mDatas.addAll(list);
                    this.showCover = false;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mDatas == null) {
                return 0;
            }
            return this.mDatas.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.mDatas == null) {
                return null;
            }
            return this.mDatas.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0816a c0816a;
            if (view == null) {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0816a c0816a2 = new C0816a(view);
                view.setTag(c0816a2);
                c0816a = c0816a2;
            } else {
                c0816a = (C0816a) view.getTag();
            }
            c0816a.a(this.mDatas.get(i), this.lDX, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0816a {
            private TextView ajF;
            private TbImageView iZv;
            private View iZw;
            private View mView;

            public C0816a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iZv = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajF = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iZw = this.mView.findViewById(R.id.emotion_cover_view);
                this.iZw.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iZv.setDefaultResource(R.drawable.img_default_100);
                        this.iZv.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (i2 == 0) {
                        if (i == 0) {
                            this.ajF.setVisibility(8);
                        }
                        if (i == 1) {
                            this.ajF.setVisibility(0);
                            ap.setBackgroundResource(this.ajF, R.drawable.emotion_pic_mine);
                        }
                        if (i == 2) {
                            this.ajF.setVisibility(0);
                            ap.setBackgroundResource(this.ajF, R.drawable.emotion_pic_single_bar);
                        }
                    } else {
                        this.ajF.setVisibility(8);
                    }
                    if (i2 == 7 && z) {
                        this.iZw.setVisibility(0);
                    } else {
                        this.iZw.setVisibility(8);
                    }
                }
            }
        }
    }
}
