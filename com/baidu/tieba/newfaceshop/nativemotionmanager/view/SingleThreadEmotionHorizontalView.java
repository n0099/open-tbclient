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
import d.a.c.e.p.l;
import d.a.c.e.q.h;
import d.a.k0.y1.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HListView f18755e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18756f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f18757g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18758h;

    /* renamed from: i  reason: collision with root package name */
    public View f18759i;
    public c j;
    public EmotionPackageData k;
    public TbPageContext l;
    public NewFaceGroupDownloadModel m;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.d {
        public a() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            if (SingleThreadEmotionHorizontalView.this.k == null) {
                return;
            }
            SingleThreadEmotionHorizontalView.this.l.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), SingleThreadEmotionHorizontalView.this.k.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.k0.y1.e.b {
        public b() {
        }

        @Override // d.a.k0.y1.e.b
        public void a(String str) {
            l.L(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), R.string.download_error);
            SingleThreadEmotionHorizontalView.this.j();
        }

        @Override // d.a.k0.y1.e.b
        public void onProgress(int i2) {
            if (i2 > 0 && i2 < 100) {
                l.J(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i2 >= 100) {
                l.I(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.a.k0.y1.e.b
        public void onSuccess(String str) {
            l.L(SingleThreadEmotionHorizontalView.this.l.getPageActivity(), R.string.down_state_success);
            SingleThreadEmotionHorizontalView.this.i();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f18763f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f18762e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public int f18764g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18765h = false;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public View f18766a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f18767b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f18768c;

            /* renamed from: d  reason: collision with root package name */
            public View f18769d;

            public a(View view) {
                this.f18766a = view;
                view.setEnabled(false);
                this.f18767b = (TbImageView) this.f18766a.findViewById(R.id.emotion_img);
                this.f18768c = (TextView) this.f18766a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f18766a.findViewById(R.id.emotion_cover_view);
                this.f18769d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i2, boolean z, int i3) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f18767b.setDefaultResource(R.drawable.img_default_100);
                    this.f18767b.V(singleEmotionData.thumbnail, 10, false);
                }
                if (i3 == 0) {
                    this.f18768c.setVisibility(0);
                } else {
                    this.f18768c.setVisibility(8);
                }
                if (i3 == 7 && z) {
                    this.f18769d.setVisibility(0);
                } else {
                    this.f18769d.setVisibility(8);
                }
            }
        }

        public c(TbPageContext tbPageContext) {
            this.f18763f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i2) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f18764g = i2;
            this.f18762e.clear();
            if (list.size() > 8) {
                this.f18762e.addAll(list.subList(0, 8));
                this.f18765h = true;
            } else {
                this.f18762e.addAll(list);
                this.f18765h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f18762e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            List<EmotionPackageData.SingleEmotionData> list = this.f18762e;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f18763f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a(this.f18762e.get(i2), this.f18764g, this.f18765h, i2);
            return view;
        }
    }

    public SingleThreadEmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.l = tbPageContext;
        g();
    }

    public final void e() {
        this.l.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.l.getPageActivity(), this.k.id, 0)));
    }

    public final void f() {
        if (ViewHelper.checkUpIsLogin(this.l.getPageActivity())) {
            if (d.m().o()) {
                l.L(this.l.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            EmotionPackageData emotionPackageData = this.k;
            if (emotionPackageData == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.m == null) {
                this.m = new NewFaceGroupDownloadModel();
            }
            this.f18758h.setEnabled(false);
            this.m.s(Integer.toString(this.k.id), Boolean.TRUE, new b());
        }
    }

    public final void g() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_single_thread_grid_item_layout, this);
        this.f18757g = viewGroup;
        this.f18755e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
        this.f18756f = (TextView) this.f18757g.findViewById(R.id.emotion_manage_title);
        this.f18759i = this.f18757g.findViewById(R.id.emotion_single_line);
        TextView textView = (TextView) this.f18757g.findViewById(R.id.emotion_manage_download);
        this.f18758h = textView;
        textView.setOnClickListener(this);
        setOnClickListener(this);
        this.f18755e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f18755e.setOnItemClickListener(new a());
        this.f18755e.setSelector(this.l.getResources().getDrawable(R.drawable.transparent_bg));
        c cVar = new c(this.l);
        this.j = cVar;
        this.f18755e.setAdapter((ListAdapter) cVar);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void h(int i2) {
        ViewGroup viewGroup = this.f18757g;
        if (viewGroup != null) {
            SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i2);
        }
        TextView textView = this.f18756f;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i2);
        }
        TextView textView2 = this.f18758h;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i2);
            SkinManager.setBackgroundResource(this.f18758h, R.drawable.bg_emotion_download, i2);
        }
        View view = this.f18759i;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
    }

    public final void i() {
        TextView textView = this.f18758h;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.f18758h, R.color.CAM_X0109);
        this.f18758h.setBackgroundDrawable(null);
        this.f18758h.setEnabled(false);
    }

    public final void j() {
        TextView textView = this.f18758h;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_manage_download);
        SkinManager.setViewTextColor(this.f18758h, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f18758h, R.drawable.bg_emotion_download);
        this.f18758h.setEnabled(true);
    }

    public final void k() {
        TextView textView = this.f18758h;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_vote);
        SkinManager.setViewTextColor(this.f18758h, R.color.CAM_X0109);
        this.f18758h.setBackgroundDrawable(null);
        this.f18758h.setEnabled(false);
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
            TextView textView = this.f18756f;
            textView.setText(this.k.forum_name + "·" + this.k.name);
        } else {
            this.f18756f.setText(this.k.name);
        }
        if (emotionPackageData.ishasdownload) {
            i();
            return;
        }
        int i2 = emotionPackageData.status;
        if (i2 == 1) {
            j();
        } else if (i2 == 5) {
            k();
        }
    }
}
