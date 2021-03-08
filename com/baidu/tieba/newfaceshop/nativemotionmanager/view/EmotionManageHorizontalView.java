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
/* loaded from: classes8.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    private View hjV;
    private NewFaceGroupDownloadModel iWa;
    private HListView jaZ;
    private EmotionPackageData jae;
    private View lFR;
    private TextView lFS;
    private View lFT;
    private TextView lFU;
    private ImageView lFV;
    private View lFW;
    private a lFX;
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
        this.jaZ = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.hjV = this.rootView.findViewById(R.id.emotion_manage_item_line);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.lFR = this.rootView.findViewById(R.id.emotion_manage_item_undownload_header);
        this.lFR.setVisibility(8);
        this.lFS = (TextView) this.rootView.findViewById(R.id.emotion_manage_undownload_total_title);
        this.lFT = this.rootView.findViewById(R.id.emotion_manage_item_grid_cover);
        this.lFT.setVisibility(8);
        this.lFU = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lFU.setVisibility(8);
        this.lFU.setOnClickListener(this);
        this.lFV = (ImageView) this.rootView.findViewById(R.id.emotion_manage_del);
        this.lFV.setVisibility(8);
        this.lFV.setOnClickListener(this);
        this.lFW = this.rootView.findViewById(R.id.emotion_manage_del_container);
        this.lFW.setOnClickListener(this);
        setOnClickListener(this);
        this.jaZ.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jaZ.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionManageHorizontalView.this.jae != null) {
                    EmotionManageHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), EmotionManageHorizontalView.this.jae.id, 0)));
                }
            }
        });
        this.jaZ.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lFX = new a(this.mPageContext);
        this.jaZ.setAdapter((ListAdapter) this.lFX);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public HListView getListView() {
        return this.jaZ;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.hjV != null) {
            ap.setBackgroundColor(this.hjV, R.color.CAM_X0204, i);
        }
        if (this.lFR != null) {
            ap.setBackgroundColor(this.lFR, R.color.CAM_X0204, i);
        }
        if (this.mTitle != null) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lFS != null) {
            ap.setViewTextColor(this.lFS, R.color.CAM_X0107, i);
        }
        if (this.lFU != null) {
            ap.setViewTextColor(this.lFU, R.color.CAM_X0302, i);
            ap.setBackgroundResource(this.lFU, R.drawable.bg_emotion_download, i);
        }
        if (this.lFV != null) {
            ap.setImageResource(this.lFV, R.drawable.emotion_manage_del_selector, i);
        }
        if (this.lFT != null) {
            ap.setViewTextColor(this.lFT, R.color.white_alpha70, i);
        }
    }

    private void a(EmotionPackageData emotionPackageData, int i) {
        if (emotionPackageData != null) {
            if (emotionPackageData.isUndownloadheader) {
                this.lFR.setVisibility(0);
                this.lFS.setText(String.format(h.getString(R.string.emotion_manage_net_number), Integer.valueOf(i)));
            } else {
                this.lFR.setVisibility(8);
            }
            djw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djv() {
        if (this.lFU != null) {
            this.lFU.setText(R.string.emotion_single_thread_downloaded);
            ap.setViewTextColor(this.lFU, R.color.CAM_X0109);
            this.lFU.setBackgroundDrawable(null);
            this.lFU.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djw() {
        if (this.lFU != null) {
            this.lFU.setText(R.string.emotion_manage_download);
            ap.setViewTextColor(this.lFU, R.color.CAM_X0302);
            ap.setBackgroundResource(this.lFU, R.drawable.bg_emotion_download);
            this.lFU.setEnabled(true);
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        this.jae = emotionPackageData;
        if (this.jae != null) {
            this.lFX.setData(this.jae.pics, emotionPackageData.typeofemotion);
            this.mTitle.setText(this.jae.name);
            if (emotionPackageData.ishasdownload) {
                this.lFT.setVisibility(8);
                this.lFU.setVisibility(8);
                if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.djh().bLg()) {
                    this.lFV.setVisibility(0);
                } else {
                    this.lFV.setVisibility(8);
                }
            } else {
                this.lFV.setVisibility(8);
                this.lFU.setVisibility(0);
                this.lFT.setVisibility(0);
            }
            a(emotionPackageData, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jae != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cyO();
            } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.lFV.isShown()) {
                if (this.jae != null) {
                    showDialog(this.jae.id);
                }
            } else {
                djx();
            }
        }
    }

    private void showDialog(final int i) {
        if (this.mPageContext != null) {
            String string = h.getString(R.string.emotion_manage_dialog_title);
            String string2 = h.getString(R.string.emotion_manage_dialog_ok);
            String string3 = h.getString(R.string.emotion_manage_dialog_cancel);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.AB(string);
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
            aVar.b(this.mPageContext).bqz();
        }
    }

    private void djx() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.jae.id, 0)));
    }

    private void cyO() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.diF().diI()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && this.jae != null && this.jae.id >= 0) {
                if (this.iWa == null) {
                    this.iWa = new NewFaceGroupDownloadModel();
                }
                this.lFU.setEnabled(false);
                this.iWa.a(Integer.toString(this.jae.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.5
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        EmotionManageHorizontalView.this.djv();
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
                        EmotionManageHorizontalView.this.djw();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eWx;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private int lFZ = 0;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eWx = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (!y.isEmpty(list)) {
                this.lFZ = i;
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
            C0822a c0822a;
            if (view == null) {
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0822a c0822a2 = new C0822a(view);
                view.setTag(c0822a2);
                c0822a = c0822a2;
            } else {
                c0822a = (C0822a) view.getTag();
            }
            c0822a.a(this.mDatas.get(i), this.lFZ, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0822a {
            private TextView akX;
            private TbImageView jbe;
            private View jbf;
            private View mView;

            public C0822a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.jbe = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.akX = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.jbf = this.mView.findViewById(R.id.emotion_cover_view);
                this.jbf.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.jbe.setDefaultResource(R.drawable.img_default_100);
                        this.jbe.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (i2 == 0) {
                        if (i == 0) {
                            this.akX.setVisibility(8);
                        }
                        if (i == 1) {
                            this.akX.setVisibility(0);
                            ap.setBackgroundResource(this.akX, R.drawable.emotion_pic_mine);
                        }
                        if (i == 2) {
                            this.akX.setVisibility(0);
                            ap.setBackgroundResource(this.akX, R.drawable.emotion_pic_single_bar);
                        }
                    } else {
                        this.akX.setVisibility(8);
                    }
                    if (i2 == 7 && z) {
                        this.jbf.setVisibility(0);
                    } else {
                        this.jbf.setVisibility(8);
                    }
                }
            }
        }
    }
}
