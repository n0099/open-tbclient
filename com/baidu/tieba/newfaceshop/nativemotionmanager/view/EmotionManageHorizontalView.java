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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.c.e.q.h;
import d.a.j0.r.s.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HListView f18736e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18737f;

    /* renamed from: g  reason: collision with root package name */
    public View f18738g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18739h;

    /* renamed from: i  reason: collision with root package name */
    public View f18740i;
    public ViewGroup j;
    public TextView k;
    public ImageView l;
    public View m;
    public View n;
    public f o;
    public EmotionPackageData p;
    public TbPageContext q;
    public NewFaceGroupDownloadModel r;
    public PermissionJudgePolicy s;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.d {
        public a() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            if (EmotionManageHorizontalView.this.p == null) {
                return;
            }
            EmotionManageHorizontalView.this.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.q.getPageActivity(), EmotionManageHorizontalView.this.p.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18742e;

        public b(int i2) {
            this.f18742e = i2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921311, Integer.valueOf(this.f18742e)));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.k0.y1.e.b {
        public e() {
        }

        @Override // d.a.k0.y1.e.b
        public void a(String str) {
            l.L(EmotionManageHorizontalView.this.q.getPageActivity(), R.string.download_error);
            EmotionManageHorizontalView.this.l();
        }

        @Override // d.a.k0.y1.e.b
        public void onProgress(int i2) {
            if (i2 > 0 && i2 < 100) {
                l.J(EmotionManageHorizontalView.this.q.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i2 >= 100) {
                l.I(EmotionManageHorizontalView.this.q.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.a.k0.y1.e.b
        public void onSuccess(String str) {
            l.L(EmotionManageHorizontalView.this.q.getPageActivity(), R.string.down_state_success);
            EmotionManageHorizontalView.this.k();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f18748f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f18747e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public int f18749g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18750h = false;

        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public View f18751a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f18752b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f18753c;

            /* renamed from: d  reason: collision with root package name */
            public View f18754d;

            public a(View view) {
                this.f18751a = view;
                view.setEnabled(false);
                this.f18752b = (TbImageView) this.f18751a.findViewById(R.id.emotion_img);
                this.f18753c = (TextView) this.f18751a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f18751a.findViewById(R.id.emotion_cover_view);
                this.f18754d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i2, boolean z, int i3) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f18752b.setDefaultResource(R.drawable.img_default_100);
                    this.f18752b.V(singleEmotionData.thumbnail, 10, false);
                }
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.f18753c.setVisibility(8);
                    }
                    if (i2 == 1) {
                        this.f18753c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f18753c, R.drawable.emotion_pic_mine);
                    }
                    if (i2 == 2) {
                        this.f18753c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f18753c, R.drawable.emotion_pic_single_bar);
                    }
                } else {
                    this.f18753c.setVisibility(8);
                }
                if (i3 == 7 && z) {
                    this.f18754d.setVisibility(0);
                } else {
                    this.f18754d.setVisibility(8);
                }
            }
        }

        public f(TbPageContext tbPageContext) {
            this.f18748f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i2) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f18749g = i2;
            this.f18747e.clear();
            if (list.size() > 8) {
                this.f18747e.addAll(list.subList(0, 8));
                this.f18750h = true;
            } else {
                this.f18747e.addAll(list);
                this.f18750h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f18747e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            List<EmotionPackageData.SingleEmotionData> list = this.f18747e;
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
                view = LayoutInflater.from(this.f18748f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a(this.f18747e.get(i2), this.f18749g, this.f18750h, i2);
            return view;
        }
    }

    public EmotionManageHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.q = tbPageContext;
        h();
    }

    public final void e(EmotionPackageData emotionPackageData, int i2) {
        if (emotionPackageData == null) {
            return;
        }
        if (emotionPackageData.isUndownloadheader) {
            this.f18738g.setVisibility(0);
            this.f18739h.setText(String.format(h.a(R.string.emotion_manage_net_number), Integer.valueOf(i2)));
        } else {
            this.f18738g.setVisibility(8);
        }
        l();
    }

    public final void f() {
        this.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.q.getPageActivity(), this.p.id, 0)));
    }

    public final void g() {
        EmotionPackageData emotionPackageData;
        if (ViewHelper.checkUpIsLogin(this.q.getPageActivity())) {
            if (d.a.k0.y1.d.m().o()) {
                l.L(this.q.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.q.getPageActivity();
            if (this.s == null) {
                this.s = new PermissionJudgePolicy();
            }
            this.s.clearRequestPermissionList();
            this.s.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.s.startRequestPermission(pageActivity) || (emotionPackageData = this.p) == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.r == null) {
                this.r = new NewFaceGroupDownloadModel();
            }
            this.k.setEnabled(false);
            this.r.s(Integer.toString(this.p.id), Boolean.TRUE, new e());
        }
    }

    public HListView getListView() {
        return this.f18736e;
    }

    public final void h() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_manage_grid_item_layout, this);
        this.j = viewGroup;
        this.f18736e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
        this.m = this.j.findViewById(R.id.emotion_manage_item_line);
        this.f18737f = (TextView) this.j.findViewById(R.id.emotion_manage_title);
        View findViewById = this.j.findViewById(R.id.emotion_manage_item_undownload_header);
        this.f18738g = findViewById;
        findViewById.setVisibility(8);
        this.f18739h = (TextView) this.j.findViewById(R.id.emotion_manage_undownload_total_title);
        View findViewById2 = this.j.findViewById(R.id.emotion_manage_item_grid_cover);
        this.f18740i = findViewById2;
        findViewById2.setVisibility(8);
        TextView textView = (TextView) this.j.findViewById(R.id.emotion_manage_download);
        this.k = textView;
        textView.setVisibility(8);
        this.k.setOnClickListener(this);
        ImageView imageView = (ImageView) this.j.findViewById(R.id.emotion_manage_del);
        this.l = imageView;
        imageView.setVisibility(8);
        this.l.setOnClickListener(this);
        View findViewById3 = this.j.findViewById(R.id.emotion_manage_del_container);
        this.n = findViewById3;
        findViewById3.setOnClickListener(this);
        setOnClickListener(this);
        this.f18736e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f18736e.setOnItemClickListener(new a());
        this.f18736e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
        f fVar = new f(this.q);
        this.o = fVar;
        this.f18736e.setAdapter((ListAdapter) fVar);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i2) {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i2);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
        }
        View view2 = this.f18738g;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f18737f;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i2);
        }
        TextView textView2 = this.f18739h;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107, i2);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0302, i2);
            SkinManager.setBackgroundResource(this.k, R.drawable.bg_emotion_download, i2);
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.emotion_manage_del_selector, i2);
        }
        View view3 = this.f18740i;
        if (view3 != null) {
            SkinManager.setViewTextColor(view3, R.color.white_alpha70, i2);
        }
    }

    public final void j(int i2) {
        if (this.q == null) {
            return;
        }
        String a2 = h.a(R.string.emotion_manage_dialog_title);
        String a3 = h.a(R.string.emotion_manage_dialog_ok);
        String a4 = h.a(R.string.emotion_manage_dialog_cancel);
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.q.getPageActivity());
        aVar.setMessage(a2);
        aVar.setPositiveButton(a3, new b(i2));
        aVar.setNegativeButton(a4, new c());
        aVar.setOnCalcelListener(new d());
        aVar.create(this.q).show();
    }

    public final void k() {
        TextView textView = this.k;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        this.k.setBackgroundDrawable(null);
        this.k.setEnabled(false);
    }

    public final void l() {
        TextView textView = this.k;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_manage_download);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.k, R.drawable.bg_emotion_download);
        this.k.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.p == null) {
            return;
        }
        if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
            g();
        } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.l.isShown()) {
            EmotionPackageData emotionPackageData = this.p;
            if (emotionPackageData != null) {
                j(emotionPackageData.id);
            }
        } else {
            f();
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i2) {
        this.p = emotionPackageData;
        if (emotionPackageData == null) {
            return;
        }
        this.o.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
        this.f18737f.setText(this.p.name);
        if (emotionPackageData.ishasdownload) {
            this.f18740i.setVisibility(8);
            this.k.setVisibility(8);
            if (d.a.k0.y1.h.a.b().a()) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        } else {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
            this.f18740i.setVisibility(0);
        }
        e(emotionPackageData, i2);
    }
}
