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
/* loaded from: classes8.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    private View hWH;
    private NewFaceGroupDownloadModel iOw;
    private EmotionPackageData iSA;
    private HListView iTv;
    private TextView lvA;
    private ImageView lvB;
    private View lvC;
    private a lvD;
    private View lvx;
    private TextView lvy;
    private View lvz;
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
        this.iTv = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.hWH = this.rootView.findViewById(R.id.emotion_manage_item_line);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.lvx = this.rootView.findViewById(R.id.emotion_manage_item_undownload_header);
        this.lvx.setVisibility(8);
        this.lvy = (TextView) this.rootView.findViewById(R.id.emotion_manage_undownload_total_title);
        this.lvz = this.rootView.findViewById(R.id.emotion_manage_item_grid_cover);
        this.lvz.setVisibility(8);
        this.lvA = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lvA.setVisibility(8);
        this.lvA.setOnClickListener(this);
        this.lvB = (ImageView) this.rootView.findViewById(R.id.emotion_manage_del);
        this.lvB.setVisibility(8);
        this.lvB.setOnClickListener(this);
        this.lvC = this.rootView.findViewById(R.id.emotion_manage_del_container);
        this.lvC.setOnClickListener(this);
        setOnClickListener(this);
        this.iTv.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iTv.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionManageHorizontalView.this.iSA != null) {
                    EmotionManageHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), EmotionManageHorizontalView.this.iSA.id, 0)));
                }
            }
        });
        this.iTv.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lvD = new a(this.mPageContext);
        this.iTv.setAdapter((ListAdapter) this.lvD);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public HListView getListView() {
        return this.iTv;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.hWH != null) {
            ao.setBackgroundColor(this.hWH, R.color.CAM_X0204, i);
        }
        if (this.lvx != null) {
            ao.setBackgroundColor(this.lvx, R.color.CAM_X0204, i);
        }
        if (this.mTitle != null) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lvy != null) {
            ao.setViewTextColor(this.lvy, R.color.CAM_X0107, i);
        }
        if (this.lvA != null) {
            ao.setViewTextColor(this.lvA, R.color.CAM_X0302, i);
            ao.setBackgroundResource(this.lvA, R.drawable.bg_emotion_download, i);
        }
        if (this.lvB != null) {
            ao.setImageResource(this.lvB, R.drawable.emotion_manage_del_selector, i);
        }
        if (this.lvz != null) {
            ao.setViewTextColor(this.lvz, R.color.white_alpha70, i);
        }
    }

    private void a(EmotionPackageData emotionPackageData, int i) {
        if (emotionPackageData != null) {
            if (emotionPackageData.isUndownloadheader) {
                this.lvx.setVisibility(0);
                this.lvy.setText(String.format(h.getString(R.string.emotion_manage_net_number), Integer.valueOf(i)));
            } else {
                this.lvx.setVisibility(8);
            }
            dhf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhe() {
        if (this.lvA != null) {
            this.lvA.setText(R.string.emotion_single_thread_downloaded);
            ao.setViewTextColor(this.lvA, R.color.CAM_X0109);
            this.lvA.setBackgroundDrawable(null);
            this.lvA.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhf() {
        if (this.lvA != null) {
            this.lvA.setText(R.string.emotion_manage_download);
            ao.setViewTextColor(this.lvA, R.color.CAM_X0302);
            ao.setBackgroundResource(this.lvA, R.drawable.bg_emotion_download);
            this.lvA.setEnabled(true);
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        this.iSA = emotionPackageData;
        if (this.iSA != null) {
            this.lvD.setData(this.iSA.pics, emotionPackageData.typeofemotion);
            this.mTitle.setText(this.iSA.name);
            if (emotionPackageData.ishasdownload) {
                this.lvz.setVisibility(8);
                this.lvA.setVisibility(8);
                if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.dgQ().bKD()) {
                    this.lvB.setVisibility(0);
                } else {
                    this.lvB.setVisibility(8);
                }
            } else {
                this.lvB.setVisibility(8);
                this.lvA.setVisibility(0);
                this.lvz.setVisibility(0);
            }
            a(emotionPackageData, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iSA != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cxq();
            } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.lvB.isShown()) {
                if (this.iSA != null) {
                    showDialog(this.iSA.id);
                }
            } else {
                dhg();
            }
        }
    }

    private void showDialog(final int i) {
        if (this.mPageContext != null) {
            String string = h.getString(R.string.emotion_manage_dialog_title);
            String string2 = h.getString(R.string.emotion_manage_dialog_ok);
            String string3 = h.getString(R.string.emotion_manage_dialog_cancel);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Ad(string);
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
            aVar.b(this.mPageContext).bqe();
        }
    }

    private void dhg() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iSA.id, 0)));
    }

    private void cxq() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.dgo().dgr()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && this.iSA != null && this.iSA.id >= 0) {
                if (this.iOw == null) {
                    this.iOw = new NewFaceGroupDownloadModel();
                }
                this.lvA.setEnabled(false);
                this.iOw.a(Integer.toString(this.iSA.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.5
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        EmotionManageHorizontalView.this.dhe();
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
                        EmotionManageHorizontalView.this.dhf();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eSJ;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private int lvF = 0;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eSJ = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (!x.isEmpty(list)) {
                this.lvF = i;
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
            C0814a c0814a;
            if (view == null) {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0814a c0814a2 = new C0814a(view);
                view.setTag(c0814a2);
                c0814a = c0814a2;
            } else {
                c0814a = (C0814a) view.getTag();
            }
            c0814a.a(this.mDatas.get(i), this.lvF, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0814a {
            private TextView ajQ;
            private TbImageView iTA;
            private View iTB;
            private View mView;

            public C0814a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iTA = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajQ = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iTB = this.mView.findViewById(R.id.emotion_cover_view);
                this.iTB.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iTA.setDefaultResource(R.drawable.img_default_100);
                        this.iTA.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (i2 == 0) {
                        if (i == 0) {
                            this.ajQ.setVisibility(8);
                        }
                        if (i == 1) {
                            this.ajQ.setVisibility(0);
                            ao.setBackgroundResource(this.ajQ, R.drawable.emotion_pic_mine);
                        }
                        if (i == 2) {
                            this.ajQ.setVisibility(0);
                            ao.setBackgroundResource(this.ajQ, R.drawable.emotion_pic_single_bar);
                        }
                    } else {
                        this.ajQ.setVisibility(8);
                    }
                    if (i2 == 7 && z) {
                        this.iTB.setVisibility(0);
                    } else {
                        this.iTB.setVisibility(8);
                    }
                }
            }
        }
    }
}
