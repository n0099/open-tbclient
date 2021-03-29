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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import d.b.b.e.p.l;
import d.b.b.e.q.h;
import d.b.i0.x1.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HListView f19332e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19333f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f19334g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19335h;
    public View i;
    public c j;
    public EmotionPackageData k;
    public TbPageContext l;
    public NewFaceGroupDownloadModel m;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.d {
        public a() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            if (SingleThreadEmotionHorizontalView.this.k == null) {
                return;
            }
            SingleThreadEmotionHorizontalView.this.l.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), SingleThreadEmotionHorizontalView.this.k.id, 0)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.i0.x1.e.b {
        public b() {
        }

        @Override // d.b.i0.x1.e.b
        public void onFail(String str) {
            l.K(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), R.string.download_error);
            SingleThreadEmotionHorizontalView.this.k();
        }

        @Override // d.b.i0.x1.e.b
        public void onProgress(int i) {
            if (i > 0 && i < 100) {
                l.I(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i >= 100) {
                l.H(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.b.i0.x1.e.b
        public void onSuccess(String str) {
            l.K(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), R.string.down_state_success);
            SingleThreadEmotionHorizontalView.this.j();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f19339f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f19338e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public int f19340g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19341h = false;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public View f19342a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f19343b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f19344c;

            /* renamed from: d  reason: collision with root package name */
            public View f19345d;

            public a(View view) {
                this.f19342a = view;
                view.setEnabled(false);
                this.f19343b = (TbImageView) this.f19342a.findViewById(R.id.emotion_img);
                this.f19344c = (TextView) this.f19342a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f19342a.findViewById(R.id.emotion_cover_view);
                this.f19345d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f19343b.setDefaultResource(R.drawable.img_default_100);
                    this.f19343b.W(singleEmotionData.thumbnail, 10, false);
                }
                if (i2 == 0) {
                    this.f19344c.setVisibility(0);
                } else {
                    this.f19344c.setVisibility(8);
                }
                if (i2 == 7 && z) {
                    this.f19345d.setVisibility(0);
                } else {
                    this.f19345d.setVisibility(8);
                }
            }
        }

        public c(TbPageContext tbPageContext) {
            this.f19339f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f19340g = i;
            this.f19338e.clear();
            if (list.size() > 8) {
                this.f19338e.addAll(list.subList(0, 8));
                this.f19341h = true;
            } else {
                this.f19338e.addAll(list);
                this.f19341h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f19338e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<EmotionPackageData.SingleEmotionData> list = this.f19338e;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f19339f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a(this.f19338e.get(i), this.f19340g, this.f19341h, i);
            return view;
        }
    }

    public SingleThreadEmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.l = tbPageContext;
        h();
    }

    public final void e() {
        this.l.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.l.getPageActivity(), this.k.id, 0)));
    }

    public final void f() {
        if (ViewHelper.checkUpIsLogin(this.l.getPageActivity())) {
            if (d.m().o()) {
                l.K(this.l.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            EmotionPackageData emotionPackageData = this.k;
            if (emotionPackageData == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.m == null) {
                this.m = new NewFaceGroupDownloadModel();
            }
            this.f19335h.setEnabled(false);
            this.m.s(Integer.toString(this.k.id), Boolean.TRUE, new b());
        }
    }

    public final void h() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_single_thread_grid_item_layout, this);
        this.f19334g = viewGroup;
        this.f19332e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
        this.f19333f = (TextView) this.f19334g.findViewById(R.id.emotion_manage_title);
        this.i = this.f19334g.findViewById(R.id.emotion_single_line);
        TextView textView = (TextView) this.f19334g.findViewById(R.id.emotion_manage_download);
        this.f19335h = textView;
        textView.setOnClickListener(this);
        setOnClickListener(this);
        this.f19332e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f19332e.setOnItemClickListener(new a());
        this.f19332e.setSelector(this.l.getResources().getDrawable(R.drawable.transparent_bg));
        c cVar = new c(this.l);
        this.j = cVar;
        this.f19332e.setAdapter((ListAdapter) cVar);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i) {
        ViewGroup viewGroup = this.f19334g;
        if (viewGroup != null) {
            SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i);
        }
        TextView textView = this.f19333f;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i);
        }
        TextView textView2 = this.f19335h;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
            SkinManager.setBackgroundResource(this.f19335h, R.drawable.bg_emotion_download, i);
        }
        View view = this.i;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
        }
    }

    public final void j() {
        TextView textView = this.f19335h;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.f19335h, R.color.CAM_X0109);
        this.f19335h.setBackgroundDrawable(null);
        this.f19335h.setEnabled(false);
    }

    public final void k() {
        TextView textView = this.f19335h;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_manage_download);
        SkinManager.setViewTextColor(this.f19335h, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f19335h, R.drawable.bg_emotion_download);
        this.f19335h.setEnabled(true);
    }

    public final void l() {
        TextView textView = this.f19335h;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_vote);
        SkinManager.setViewTextColor(this.f19335h, R.color.CAM_X0109);
        this.f19335h.setBackgroundDrawable(null);
        this.f19335h.setEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.k == null) {
            return;
        }
        if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
            f();
        } else {
            e();
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.k = emotionPackageData;
        if (emotionPackageData == null) {
            return;
        }
        this.j.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
        if (!TextUtils.isEmpty(this.k.forum_name)) {
            TextView textView = this.f19333f;
            textView.setText(this.k.forum_name + "·" + this.k.name);
        } else {
            this.f19333f.setText(this.k.name);
        }
        if (emotionPackageData.ishasdownload) {
            j();
            return;
        }
        int i = emotionPackageData.status;
        if (i == 1) {
            k();
        } else if (i == 5) {
            l();
        }
    }
}
