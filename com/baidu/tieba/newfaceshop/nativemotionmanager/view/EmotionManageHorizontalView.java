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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
    private NewFaceGroupDownloadModel iTd;
    private EmotionPackageData iXh;
    private HListView iYc;
    private View ibo;
    private View lAd;
    private TextView lAe;
    private View lAf;
    private TextView lAg;
    private ImageView lAh;
    private View lAi;
    private a lAj;
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
        this.iYc = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.ibo = this.rootView.findViewById(R.id.emotion_manage_item_line);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.lAd = this.rootView.findViewById(R.id.emotion_manage_item_undownload_header);
        this.lAd.setVisibility(8);
        this.lAe = (TextView) this.rootView.findViewById(R.id.emotion_manage_undownload_total_title);
        this.lAf = this.rootView.findViewById(R.id.emotion_manage_item_grid_cover);
        this.lAf.setVisibility(8);
        this.lAg = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lAg.setVisibility(8);
        this.lAg.setOnClickListener(this);
        this.lAh = (ImageView) this.rootView.findViewById(R.id.emotion_manage_del);
        this.lAh.setVisibility(8);
        this.lAh.setOnClickListener(this);
        this.lAi = this.rootView.findViewById(R.id.emotion_manage_del_container);
        this.lAi.setOnClickListener(this);
        setOnClickListener(this);
        this.iYc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iYc.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionManageHorizontalView.this.iXh != null) {
                    EmotionManageHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), EmotionManageHorizontalView.this.iXh.id, 0)));
                }
            }
        });
        this.iYc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lAj = new a(this.mPageContext);
        this.iYc.setAdapter((ListAdapter) this.lAj);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public HListView getListView() {
        return this.iYc;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.ibo != null) {
            ao.setBackgroundColor(this.ibo, R.color.CAM_X0204, i);
        }
        if (this.lAd != null) {
            ao.setBackgroundColor(this.lAd, R.color.CAM_X0204, i);
        }
        if (this.mTitle != null) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lAe != null) {
            ao.setViewTextColor(this.lAe, R.color.CAM_X0107, i);
        }
        if (this.lAg != null) {
            ao.setViewTextColor(this.lAg, R.color.CAM_X0302, i);
            ao.setBackgroundResource(this.lAg, R.drawable.bg_emotion_download, i);
        }
        if (this.lAh != null) {
            ao.setImageResource(this.lAh, R.drawable.emotion_manage_del_selector, i);
        }
        if (this.lAf != null) {
            ao.setViewTextColor(this.lAf, R.color.white_alpha70, i);
        }
    }

    private void a(EmotionPackageData emotionPackageData, int i) {
        if (emotionPackageData != null) {
            if (emotionPackageData.isUndownloadheader) {
                this.lAd.setVisibility(0);
                this.lAe.setText(String.format(h.getString(R.string.emotion_manage_net_number), Integer.valueOf(i)));
            } else {
                this.lAd.setVisibility(8);
            }
            dkX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkW() {
        if (this.lAg != null) {
            this.lAg.setText(R.string.emotion_single_thread_downloaded);
            ao.setViewTextColor(this.lAg, R.color.CAM_X0109);
            this.lAg.setBackgroundDrawable(null);
            this.lAg.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkX() {
        if (this.lAg != null) {
            this.lAg.setText(R.string.emotion_manage_download);
            ao.setViewTextColor(this.lAg, R.color.CAM_X0302);
            ao.setBackgroundResource(this.lAg, R.drawable.bg_emotion_download);
            this.lAg.setEnabled(true);
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        this.iXh = emotionPackageData;
        if (this.iXh != null) {
            this.lAj.setData(this.iXh.pics, emotionPackageData.typeofemotion);
            this.mTitle.setText(this.iXh.name);
            if (emotionPackageData.ishasdownload) {
                this.lAf.setVisibility(8);
                this.lAg.setVisibility(8);
                if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.dkI().bOv()) {
                    this.lAh.setVisibility(0);
                } else {
                    this.lAh.setVisibility(8);
                }
            } else {
                this.lAh.setVisibility(8);
                this.lAg.setVisibility(0);
                this.lAf.setVisibility(0);
            }
            a(emotionPackageData, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iXh != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cBi();
            } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.lAh.isShown()) {
                if (this.iXh != null) {
                    showDialog(this.iXh.id);
                }
            } else {
                dkY();
            }
        }
    }

    private void showDialog(final int i) {
        if (this.mPageContext != null) {
            String string = h.getString(R.string.emotion_manage_dialog_title);
            String string2 = h.getString(R.string.emotion_manage_dialog_ok);
            String string3 = h.getString(R.string.emotion_manage_dialog_cancel);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Bo(string);
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
            aVar.b(this.mPageContext).btY();
        }
    }

    private void dkY() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iXh.id, 0)));
    }

    private void cBi() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.dkg().dkj()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && this.iXh != null && this.iXh.id >= 0) {
                if (this.iTd == null) {
                    this.iTd = new NewFaceGroupDownloadModel();
                }
                this.lAg.setEnabled(false);
                this.iTd.a(Integer.toString(this.iXh.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.5
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        EmotionManageHorizontalView.this.dkW();
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
                        EmotionManageHorizontalView.this.dkX();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eXu;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private int lAl = 0;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eXu = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (!x.isEmpty(list)) {
                this.lAl = i;
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
            C0831a c0831a;
            if (view == null) {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0831a c0831a2 = new C0831a(view);
                view.setTag(c0831a2);
                c0831a = c0831a2;
            } else {
                c0831a = (C0831a) view.getTag();
            }
            c0831a.a(this.mDatas.get(i), this.lAl, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0831a {
            private TextView akH;
            private TbImageView iYh;
            private View iYi;
            private View mView;

            public C0831a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iYh = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.akH = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iYi = this.mView.findViewById(R.id.emotion_cover_view);
                this.iYi.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iYh.setDefaultResource(R.drawable.img_default_100);
                        this.iYh.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (i2 == 0) {
                        if (i == 0) {
                            this.akH.setVisibility(8);
                        }
                        if (i == 1) {
                            this.akH.setVisibility(0);
                            ao.setBackgroundResource(this.akH, R.drawable.emotion_pic_mine);
                        }
                        if (i == 2) {
                            this.akH.setVisibility(0);
                            ao.setBackgroundResource(this.akH, R.drawable.emotion_pic_single_bar);
                        }
                    } else {
                        this.akH.setVisibility(8);
                    }
                    if (i2 == 7 && z) {
                        this.iYi.setVisibility(0);
                    } else {
                        this.iYi.setVisibility(8);
                    }
                }
            }
        }
    }
}
