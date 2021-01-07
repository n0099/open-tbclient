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
/* loaded from: classes9.dex */
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    private NewFaceGroupDownloadModel iTd;
    private EmotionPackageData iXh;
    private HListView iYc;
    private View ibo;
    private TextView lAg;
    private a lAw;
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
        this.iYc = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.ibo = this.rootView.findViewById(R.id.emotion_single_line);
        this.lAg = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lAg.setOnClickListener(this);
        setOnClickListener(this);
        this.iYc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iYc.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (SingleThreadEmotionHorizontalView.this.iXh != null) {
                    SingleThreadEmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), SingleThreadEmotionHorizontalView.this.iXh.id, 0)));
                }
            }
        });
        this.iYc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lAw = new a(this.mPageContext);
        this.iYc.setAdapter((ListAdapter) this.lAw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.mTitle != null) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lAg != null) {
            ao.setViewTextColor(this.lAg, R.color.CAM_X0302, i);
            ao.setBackgroundResource(this.lAg, R.drawable.bg_emotion_download, i);
        }
        if (this.ibo != null) {
            ao.setBackgroundColor(this.ibo, R.color.CAM_X0204, i);
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.iXh = emotionPackageData;
        if (this.iXh != null) {
            this.lAw.setData(this.iXh.pics, emotionPackageData.typeofemotion);
            if (!TextUtils.isEmpty(this.iXh.forum_name)) {
                this.mTitle.setText(this.iXh.forum_name + "·" + this.iXh.name);
            } else {
                this.mTitle.setText(this.iXh.name);
            }
            if (emotionPackageData.ishasdownload) {
                dkW();
            } else if (emotionPackageData.status == 1) {
                dkX();
            } else if (emotionPackageData.status == 5) {
                dlc();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iXh != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cBi();
            } else {
                dkY();
            }
        }
    }

    private void dkY() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iXh.id, 0)));
    }

    private void cBi() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.dkg().dkj()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            } else if (this.iXh != null && this.iXh.id >= 0) {
                if (this.iTd == null) {
                    this.iTd = new NewFaceGroupDownloadModel();
                }
                this.lAg.setEnabled(false);
                this.iTd.a(Integer.toString(this.iXh.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView.2
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        SingleThreadEmotionHorizontalView.this.dkW();
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
                        SingleThreadEmotionHorizontalView.this.dkX();
                    }
                });
            }
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

    private void dlc() {
        if (this.lAg != null) {
            this.lAg.setText(R.string.emotion_single_thread_vote);
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
            C0832a c0832a;
            if (view == null) {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0832a c0832a2 = new C0832a(view);
                view.setTag(c0832a2);
                c0832a = c0832a2;
            } else {
                c0832a = (C0832a) view.getTag();
            }
            c0832a.a(this.mDatas.get(i), this.lAl, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0832a {
            private TextView akH;
            private TbImageView iYh;
            private View iYi;
            private View mView;

            public C0832a(View view) {
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
                        this.akH.setVisibility(0);
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
