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
    private View hhX;
    private NewFaceGroupDownloadModel iUd;
    private EmotionPackageData iYh;
    private HListView iZc;
    private View lDB;
    private TextView lDC;
    private View lDD;
    private TextView lDE;
    private ImageView lDF;
    private View lDG;
    private a lDH;
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
        this.iZc = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.hhX = this.rootView.findViewById(R.id.emotion_manage_item_line);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.lDB = this.rootView.findViewById(R.id.emotion_manage_item_undownload_header);
        this.lDB.setVisibility(8);
        this.lDC = (TextView) this.rootView.findViewById(R.id.emotion_manage_undownload_total_title);
        this.lDD = this.rootView.findViewById(R.id.emotion_manage_item_grid_cover);
        this.lDD.setVisibility(8);
        this.lDE = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lDE.setVisibility(8);
        this.lDE.setOnClickListener(this);
        this.lDF = (ImageView) this.rootView.findViewById(R.id.emotion_manage_del);
        this.lDF.setVisibility(8);
        this.lDF.setOnClickListener(this);
        this.lDG = this.rootView.findViewById(R.id.emotion_manage_del_container);
        this.lDG.setOnClickListener(this);
        setOnClickListener(this);
        this.iZc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZc.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionManageHorizontalView.this.iYh != null) {
                    EmotionManageHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), EmotionManageHorizontalView.this.iYh.id, 0)));
                }
            }
        });
        this.iZc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lDH = new a(this.mPageContext);
        this.iZc.setAdapter((ListAdapter) this.lDH);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public HListView getListView() {
        return this.iZc;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.hhX != null) {
            ap.setBackgroundColor(this.hhX, R.color.CAM_X0204, i);
        }
        if (this.lDB != null) {
            ap.setBackgroundColor(this.lDB, R.color.CAM_X0204, i);
        }
        if (this.mTitle != null) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lDC != null) {
            ap.setViewTextColor(this.lDC, R.color.CAM_X0107, i);
        }
        if (this.lDE != null) {
            ap.setViewTextColor(this.lDE, R.color.CAM_X0302, i);
            ap.setBackgroundResource(this.lDE, R.drawable.bg_emotion_download, i);
        }
        if (this.lDF != null) {
            ap.setImageResource(this.lDF, R.drawable.emotion_manage_del_selector, i);
        }
        if (this.lDD != null) {
            ap.setViewTextColor(this.lDD, R.color.white_alpha70, i);
        }
    }

    private void a(EmotionPackageData emotionPackageData, int i) {
        if (emotionPackageData != null) {
            if (emotionPackageData.isUndownloadheader) {
                this.lDB.setVisibility(0);
                this.lDC.setText(String.format(h.getString(R.string.emotion_manage_net_number), Integer.valueOf(i)));
            } else {
                this.lDB.setVisibility(8);
            }
            djg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djf() {
        if (this.lDE != null) {
            this.lDE.setText(R.string.emotion_single_thread_downloaded);
            ap.setViewTextColor(this.lDE, R.color.CAM_X0109);
            this.lDE.setBackgroundDrawable(null);
            this.lDE.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djg() {
        if (this.lDE != null) {
            this.lDE.setText(R.string.emotion_manage_download);
            ap.setViewTextColor(this.lDE, R.color.CAM_X0302);
            ap.setBackgroundResource(this.lDE, R.drawable.bg_emotion_download);
            this.lDE.setEnabled(true);
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        this.iYh = emotionPackageData;
        if (this.iYh != null) {
            this.lDH.setData(this.iYh.pics, emotionPackageData.typeofemotion);
            this.mTitle.setText(this.iYh.name);
            if (emotionPackageData.ishasdownload) {
                this.lDD.setVisibility(8);
                this.lDE.setVisibility(8);
                if (com.baidu.tieba.newfaceshop.nativemotionmanager.a.diR().bKX()) {
                    this.lDF.setVisibility(0);
                } else {
                    this.lDF.setVisibility(8);
                }
            } else {
                this.lDF.setVisibility(8);
                this.lDE.setVisibility(0);
                this.lDD.setVisibility(0);
            }
            a(emotionPackageData, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iYh != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cyB();
            } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.lDF.isShown()) {
                if (this.iYh != null) {
                    showDialog(this.iYh.id);
                }
            } else {
                djh();
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

    private void djh() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iYh.id, 0)));
    }

    private void cyB() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.dip().dis()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity) && this.iYh != null && this.iYh.id >= 0) {
                if (this.iUd == null) {
                    this.iUd = new NewFaceGroupDownloadModel();
                }
                this.lDE.setEnabled(false);
                this.iUd.a(Integer.toString(this.iYh.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView.5
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(EmotionManageHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        EmotionManageHorizontalView.this.djf();
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
                        EmotionManageHorizontalView.this.djg();
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
        private int lDJ = 0;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eUY = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (!y.isEmpty(list)) {
                this.lDJ = i;
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
            C0815a c0815a;
            if (view == null) {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0815a c0815a2 = new C0815a(view);
                view.setTag(c0815a2);
                c0815a = c0815a2;
            } else {
                c0815a = (C0815a) view.getTag();
            }
            c0815a.a(this.mDatas.get(i), this.lDJ, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0815a {
            private TextView ajF;
            private TbImageView iZh;
            private View iZi;
            private View mView;

            public C0815a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iZh = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajF = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iZi = this.mView.findViewById(R.id.emotion_cover_view);
                this.iZi.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iZh.setDefaultResource(R.drawable.img_default_100);
                        this.iZh.startLoad(singleEmotionData.thumbnail, 10, false);
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
                        this.iZi.setVisibility(0);
                    } else {
                        this.iZi.setVisibility(8);
                    }
                }
            }
        }
    }
}
