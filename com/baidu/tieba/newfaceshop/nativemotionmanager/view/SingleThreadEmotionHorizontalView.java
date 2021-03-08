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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
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
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    private View hjV;
    private NewFaceGroupDownloadModel iWa;
    private HListView jaZ;
    private EmotionPackageData jae;
    private TextView lFU;
    private a lGk;
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
        this.jaZ = (HListView) this.rootView.findViewById(R.id.emotion_manage_item_grid);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.emotion_manage_title);
        this.hjV = this.rootView.findViewById(R.id.emotion_single_line);
        this.lFU = (TextView) this.rootView.findViewById(R.id.emotion_manage_download);
        this.lFU.setOnClickListener(this);
        setOnClickListener(this);
        this.jaZ.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jaZ.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (SingleThreadEmotionHorizontalView.this.jae != null) {
                    SingleThreadEmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), SingleThreadEmotionHorizontalView.this.jae.id, 0)));
                }
            }
        });
        this.jaZ.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.lGk = new a(this.mPageContext);
        this.jaZ.setAdapter((ListAdapter) this.lGk);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201, i);
        }
        if (this.mTitle != null) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
        }
        if (this.lFU != null) {
            ap.setViewTextColor(this.lFU, R.color.CAM_X0302, i);
            ap.setBackgroundResource(this.lFU, R.drawable.bg_emotion_download, i);
        }
        if (this.hjV != null) {
            ap.setBackgroundColor(this.hjV, R.color.CAM_X0204, i);
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.jae = emotionPackageData;
        if (this.jae != null) {
            this.lGk.setData(this.jae.pics, emotionPackageData.typeofemotion);
            if (!TextUtils.isEmpty(this.jae.forum_name)) {
                this.mTitle.setText(this.jae.forum_name + "·" + this.jae.name);
            } else {
                this.mTitle.setText(this.jae.name);
            }
            if (emotionPackageData.ishasdownload) {
                djv();
            } else if (emotionPackageData.status == 1) {
                djw();
            } else if (emotionPackageData.status == 5) {
                djB();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jae != null) {
            if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
                cyO();
            } else {
                djx();
            }
        }
    }

    private void djx() {
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.jae.id, 0)));
    }

    private void cyO() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (com.baidu.tieba.newfaceshop.d.diF().diI()) {
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            } else if (this.jae != null && this.jae.id >= 0) {
                if (this.iWa == null) {
                    this.iWa = new NewFaceGroupDownloadModel();
                }
                this.lFU.setEnabled(false);
                this.iWa.a(Integer.toString(this.jae.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView.2
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(String str) {
                        l.showToast(SingleThreadEmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                        SingleThreadEmotionHorizontalView.this.djv();
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
                        SingleThreadEmotionHorizontalView.this.djw();
                    }
                });
            }
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

    private void djB() {
        if (this.lFU != null) {
            this.lFU.setText(R.string.emotion_single_thread_vote);
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
            C0823a c0823a;
            if (view == null) {
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0823a c0823a2 = new C0823a(view);
                view.setTag(c0823a2);
                c0823a = c0823a2;
            } else {
                c0823a = (C0823a) view.getTag();
            }
            c0823a.a(this.mDatas.get(i), this.lFZ, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0823a {
            private TextView akX;
            private TbImageView jbe;
            private View jbf;
            private View mView;

            public C0823a(View view) {
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
                        this.akX.setVisibility(0);
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
