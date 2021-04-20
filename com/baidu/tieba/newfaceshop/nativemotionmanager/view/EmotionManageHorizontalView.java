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
import d.b.c.e.p.l;
import d.b.c.e.q.h;
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HListView f18991e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18992f;

    /* renamed from: g  reason: collision with root package name */
    public View f18993g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18994h;
    public View i;
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

    /* loaded from: classes3.dex */
    public class a implements AdapterView.d {
        public a() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            if (EmotionManageHorizontalView.this.p == null) {
                return;
            }
            EmotionManageHorizontalView.this.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionManageHorizontalView.this.q.getPageActivity(), EmotionManageHorizontalView.this.p.id, 0)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18996e;

        public b(int i) {
            this.f18996e = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921311, Integer.valueOf(this.f18996e)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.i0.y1.e.b {
        public e() {
        }

        @Override // d.b.i0.y1.e.b
        public void onFail(String str) {
            l.K(EmotionManageHorizontalView.this.q.getPageActivity(), R.string.download_error);
            EmotionManageHorizontalView.this.m();
        }

        @Override // d.b.i0.y1.e.b
        public void onProgress(int i) {
            if (i > 0 && i < 100) {
                l.I(EmotionManageHorizontalView.this.q.getPageActivity(), h.a(R.string.package_downloading_progress));
            } else if (i >= 100) {
                l.H(EmotionManageHorizontalView.this.q.getPageActivity(), R.string.down_state_success);
            }
        }

        @Override // d.b.i0.y1.e.b
        public void onSuccess(String str) {
            l.K(EmotionManageHorizontalView.this.q.getPageActivity(), R.string.down_state_success);
            EmotionManageHorizontalView.this.l();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f19002f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f19001e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public int f19003g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19004h = false;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public View f19005a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f19006b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f19007c;

            /* renamed from: d  reason: collision with root package name */
            public View f19008d;

            public a(View view) {
                this.f19005a = view;
                view.setEnabled(false);
                this.f19006b = (TbImageView) this.f19005a.findViewById(R.id.emotion_img);
                this.f19007c = (TextView) this.f19005a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f19005a.findViewById(R.id.emotion_cover_view);
                this.f19008d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f19006b.setDefaultResource(R.drawable.img_default_100);
                    this.f19006b.W(singleEmotionData.thumbnail, 10, false);
                }
                if (i2 == 0) {
                    if (i == 0) {
                        this.f19007c.setVisibility(8);
                    }
                    if (i == 1) {
                        this.f19007c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f19007c, R.drawable.emotion_pic_mine);
                    }
                    if (i == 2) {
                        this.f19007c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f19007c, R.drawable.emotion_pic_single_bar);
                    }
                } else {
                    this.f19007c.setVisibility(8);
                }
                if (i2 == 7 && z) {
                    this.f19008d.setVisibility(0);
                } else {
                    this.f19008d.setVisibility(8);
                }
            }
        }

        public f(TbPageContext tbPageContext) {
            this.f19002f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f19003g = i;
            this.f19001e.clear();
            if (list.size() > 8) {
                this.f19001e.addAll(list.subList(0, 8));
                this.f19004h = true;
            } else {
                this.f19001e.addAll(list);
                this.f19004h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f19001e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<EmotionPackageData.SingleEmotionData> list = this.f19001e;
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
                view = LayoutInflater.from(this.f19002f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.a(this.f19001e.get(i), this.f19003g, this.f19004h, i);
            return view;
        }
    }

    public EmotionManageHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.q = tbPageContext;
        i();
    }

    public final void e(EmotionPackageData emotionPackageData, int i) {
        if (emotionPackageData == null) {
            return;
        }
        if (emotionPackageData.isUndownloadheader) {
            this.f18993g.setVisibility(0);
            this.f18994h.setText(String.format(h.a(R.string.emotion_manage_net_number), Integer.valueOf(i)));
        } else {
            this.f18993g.setVisibility(8);
        }
        m();
    }

    public final void f() {
        this.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.q.getPageActivity(), this.p.id, 0)));
    }

    public HListView getListView() {
        return this.f18991e;
    }

    public final void h() {
        EmotionPackageData emotionPackageData;
        if (ViewHelper.checkUpIsLogin(this.q.getPageActivity())) {
            if (d.b.i0.y1.d.m().o()) {
                l.K(this.q.getPageActivity(), R.string.face_group_is_syncing);
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

    public final void i() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_manage_grid_item_layout, this);
        this.j = viewGroup;
        this.f18991e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
        this.m = this.j.findViewById(R.id.emotion_manage_item_line);
        this.f18992f = (TextView) this.j.findViewById(R.id.emotion_manage_title);
        View findViewById = this.j.findViewById(R.id.emotion_manage_item_undownload_header);
        this.f18993g = findViewById;
        findViewById.setVisibility(8);
        this.f18994h = (TextView) this.j.findViewById(R.id.emotion_manage_undownload_total_title);
        View findViewById2 = this.j.findViewById(R.id.emotion_manage_item_grid_cover);
        this.i = findViewById2;
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
        this.f18991e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f18991e.setOnItemClickListener(new a());
        this.f18991e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
        f fVar = new f(this.q);
        this.o = fVar;
        this.f18991e.setAdapter((ListAdapter) fVar);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(int i) {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i);
        }
        View view = this.m;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
        }
        View view2 = this.f18993g;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i);
        }
        TextView textView = this.f18992f;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i);
        }
        TextView textView2 = this.f18994h;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107, i);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0302, i);
            SkinManager.setBackgroundResource(this.k, R.drawable.bg_emotion_download, i);
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.emotion_manage_del_selector, i);
        }
        View view3 = this.i;
        if (view3 != null) {
            SkinManager.setViewTextColor(view3, R.color.white_alpha70, i);
        }
    }

    public final void k(int i) {
        if (this.q == null) {
            return;
        }
        String a2 = h.a(R.string.emotion_manage_dialog_title);
        String a3 = h.a(R.string.emotion_manage_dialog_ok);
        String a4 = h.a(R.string.emotion_manage_dialog_cancel);
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.q.getPageActivity());
        aVar.setMessage(a2);
        aVar.setPositiveButton(a3, new b(i));
        aVar.setNegativeButton(a4, new c());
        aVar.setOnCalcelListener(new d());
        aVar.create(this.q).show();
    }

    public final void l() {
        TextView textView = this.k;
        if (textView == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        this.k.setBackgroundDrawable(null);
        this.k.setEnabled(false);
    }

    public final void m() {
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
            h();
        } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.l.isShown()) {
            EmotionPackageData emotionPackageData = this.p;
            if (emotionPackageData != null) {
                k(emotionPackageData.id);
            }
        } else {
            f();
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        this.p = emotionPackageData;
        if (emotionPackageData == null) {
            return;
        }
        this.o.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
        this.f18992f.setText(this.p.name);
        if (emotionPackageData.ishasdownload) {
            this.i.setVisibility(8);
            this.k.setVisibility(8);
            if (d.b.i0.y1.h.a.b().a()) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        } else {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
            this.i.setVisibility(0);
        }
        e(emotionPackageData, i);
    }
}
