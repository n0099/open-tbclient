package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
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
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    private View hWH;
    private NewFaceGroupDownloadModel iOw;
    private EmotionPackageData iSA;
    private HListView iTv;
    private TextView lvA;
    private a lvQ;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private ViewGroup rootView;

    public SingleThreadEmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.rootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_single_thread_grid_item_layout, this);
        this.iTv = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.hWH = this.rootView.findViewById(R.id.emotion_single_line);
        this.lvA = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lvA.setOnClickListener(this);
        setOnClickListener(this);
        this.iTv.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iTv.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (SingleThreadEmotionHorizontalView.this.iSA != null) {
                    SingleThreadEmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), SingleThreadEmotionHorizontalView.this.iSA.id, 0)));
                }
            }
        });
        this.iTv.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lvQ = new a(this.mPageContext);
        this.iTv.setAdapter((ListAdapter) this.lvQ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.mTitle != null) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lvA != null) {
            ao.setViewTextColor(this.lvA, R.color.CAM_X0302, i);
            ao.setBackgroundResource(this.lvA, R.drawable.bg_emotion_download, i);
        }
        if (this.hWH != null) {
            ao.setBackgroundColor(this.hWH, R.color.CAM_X0204, i);
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.iSA = emotionPackageData;
        if (this.iSA != null) {
            this.lvQ.setData(this.iSA.pics, emotionPackageData.typeofemotion);
            if (!TextUtils.isEmpty(this.iSA.forum_name)) {
                this.mTitle.setText(this.iSA.forum_name + "·" + this.iSA.name);
            } else {
                this.mTitle.setText(this.iSA.name);
            }
            if (emotionPackageData.ishasdownload) {
                dhe();
            } else if (emotionPackageData.status == 1) {
                dhf();
            } else if (emotionPackageData.status == 5) {
                dhk();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iSA != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cxq();
            } else {
                dhg();
            }
        }
    }

    private void dhg() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iSA.id, 0)));
    }

    private void cxq() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.dgo().dgr()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            } else if (this.iSA != null && this.iSA.id >= 0) {
                if (this.iOw == null) {
                    this.iOw = new NewFaceGroupDownloadModel();
                }
                this.lvA.setEnabled(false);
                this.iOw.a(Integer.toString(this.iSA.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView.2
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        SingleThreadEmotionHorizontalView.this.dhe();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onProgress(int i) {
                        if (i > 0 && i < 100) {
                            l.showLongToast(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), h.getString(R.string.package_downloading_progress));
                        } else if (i >= 100) {
                            l.showLongToast(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        }
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onFail(String str) {
                        l.showToast(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.download_error);
                        SingleThreadEmotionHorizontalView.this.dhf();
                    }
                });
            }
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

    private void dhk() {
        if (this.lvA != null) {
            this.lvA.setText(R.string.emotion_single_thread_vote);
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
            C0815a c0815a;
            if (view == null) {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0815a c0815a2 = new C0815a(view);
                view.setTag(c0815a2);
                c0815a = c0815a2;
            } else {
                c0815a = (C0815a) view.getTag();
            }
            c0815a.a(this.mDatas.get(i), this.lvF, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0815a {
            private TextView ajQ;
            private TbImageView iTA;
            private View iTB;
            private View mView;

            public C0815a(View view) {
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
                        this.ajQ.setVisibility(0);
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
