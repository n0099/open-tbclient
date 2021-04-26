package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import d.a.c.a.e;
import d.a.c.e.p.l;
import d.a.i0.c.f;
import d.a.j0.s2.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    public FormCard A;
    public List<d> B;
    public String C;
    public int D;
    public int E;
    public TbPageContext F;
    public float G;
    public TitleView r;
    public CommitView s;
    public LinearLayout t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public View y;
    public Activity z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FormCardView formCardView = FormCardView.this;
            formCardView.Z(formCardView.B, FormCardView.this.s.getPostUrl(), FormCardView.this.C);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar != null) {
                try {
                    if (aVar.p() != null) {
                        int height = aVar.p().getHeight();
                        int width = aVar.p().getWidth();
                        if (width == 0) {
                            return;
                        }
                        int i3 = (FormCardView.this.D * height) / width;
                        int i4 = FormCardView.this.A.backgroundInfo.f20965c;
                        if (i4 == 1) {
                            FormCardView.this.v.getLayoutParams().width = FormCardView.this.D;
                            FormCardView.this.v.getLayoutParams().height = i3;
                        } else if (i4 == 2) {
                            FormCardView.this.v.getLayoutParams().width = FormCardView.this.D;
                            FormCardView.this.v.getLayoutParams().height = FormCardView.this.E;
                        }
                        int b2 = d.a.j0.j1.o.k.b.b(FormCardView.this.A.backgroundInfo.f20964b);
                        if (!d.a.j0.j1.o.k.b.a(b2)) {
                            FormCardView.this.y.setBackgroundColor(b2);
                        }
                        aVar.h(FormCardView.this.v);
                        return;
                    }
                } catch (Exception unused) {
                    FormCardView.this.v.setImageBitmap(null);
                    FormCardView.this.v.setVisibility(8);
                    return;
                } catch (OutOfMemoryError unused2) {
                    FormCardView.this.v.setImageBitmap(null);
                    FormCardView.this.v.setVisibility(8);
                    return;
                }
            }
            FormCardView.this.v.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (fVar.f48361a) {
                    FormCardView.this.A.setCommitState(true);
                    FormCardView.this.i0();
                } else if (!TextUtils.isEmpty(fVar.f48363c)) {
                    new d.a.i0.r.f0.c().b(fVar.f48363c);
                    FormCardView.this.A.setCommitState(false);
                } else {
                    new d.a.i0.r.f0.c().d(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                    FormCardView.this.A.setCommitState(false);
                }
            }
            FormCardView.this.s.setClickable(true);
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a();

        FormItemBaseView getFormView();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.C = "";
        this.D = 0;
        this.E = 0;
        this.G = 1.0f;
        this.F = tbPageContext;
        this.z = tbPageContext.getPageActivity();
        this.D = l.k(TbadkCoreApplication.getInst());
    }

    public final JSONObject S(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", str);
            jSONObject.put("value", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void T(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.s.setClickable(true);
        } else {
            d.a.j0.s2.z.b.a().d(null, str, hashMap, new c());
        }
    }

    public final void V() {
        this.y.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.A.backgroundInfo != null) {
            this.v.setVisibility(0);
            if (!TextUtils.isEmpty(this.A.backgroundInfo.f20963a)) {
                d.a.c.e.l.d.h().m(this.A.backgroundInfo.f20963a, 10, new b(), this.F.getUniqueId());
                return;
            }
        }
        this.v.setVisibility(8);
    }

    public final void W() {
        FormCard.f fVar = this.A.resultInfo;
        float dimension = this.m.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.m.getResources().getDimension(R.dimen.fontsize28);
        int color = this.m.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.w.setText(fVar.f20974a);
            this.w.setTextColor(-1);
            this.w.setTextSize(0, dimension);
            this.x.setText(fVar.f20975b);
            this.x.setTextColor(color);
            this.x.setTextSize(0, dimension2);
        }
    }

    public final void X() {
        List<FormCard.b> list = this.A.itemList;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.A.itemList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FormCard.b bVar = this.A.itemList.get(i2);
            if (bVar != null) {
                switch (bVar.f20966a) {
                    case 1:
                        Y(bVar, new TitleView(this.z), i2, size);
                        continue;
                    case 2:
                        Y(bVar, new CommitView(this.z), i2, size);
                        continue;
                    case 3:
                    case 4:
                    case 5:
                        Y(bVar, new EditView(this.z), i2, size);
                        continue;
                    case 6:
                    case 7:
                    case 8:
                        Y(bVar, new PickerView(this.z), i2, size);
                        continue;
                }
            }
        }
    }

    public final void Y(FormCard.b bVar, FormItemBaseView formItemBaseView, int i2, int i3) {
        formItemBaseView.f(this.G);
        formItemBaseView.g(bVar);
        h0(formItemBaseView, i2, i3);
        e0(formItemBaseView);
        this.u.addView(formItemBaseView);
    }

    public void Z(List<d> list, String str, String str2) {
        JSONObject S;
        if (list == null || list.size() < 1) {
            return;
        }
        boolean z = true;
        for (d dVar : list) {
            FormItemBaseView formView = dVar.getFormView();
            if (formView != null) {
                if (!dVar.a()) {
                    View frameView = formView.getFrameView();
                    if (frameView != null) {
                        formView.c(frameView, FormItemBaseView.DrawableType.ERROR_FRAME);
                    }
                    z = false;
                } else {
                    View frameView2 = formView.getFrameView();
                    if (frameView2 != null) {
                        formView.c(frameView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                    }
                }
            }
        }
        if (z) {
            JSONArray jSONArray = new JSONArray();
            for (d dVar2 : list) {
                FormItemBaseView formView2 = dVar2.getFormView();
                if (formView2 != null && (S = S(formView2.getTag(), formView2.getResult())) != null) {
                    jSONArray.put(S);
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("commit_content", jSONArray.toString());
            hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
            hashMap.put("url", str);
            T(str, hashMap);
            this.s.setClickable(false);
            return;
        }
        new d.a.i0.r.f0.c().d(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
        this.s.setClickable(true);
    }

    public final void a0() {
        CommitView commitView = this.s;
        if (commitView != null) {
            commitView.getCommitButton().setOnClickListener(new a());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b0 */
    public void x(FormCard formCard, int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: d0 */
    public void y(FormCard formCard) {
        if (formCard == null || !formCard.mIsLegal || this.A == formCard) {
            return;
        }
        f0();
        this.A = formCard;
        this.C = formCard.getItemId();
        g0(formCard.mWidth, formCard.mHeight);
        this.r.f(this.G);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.r.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = (int) (((int) this.z.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.G);
        }
        this.s.f(this.G);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.s.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.bottomMargin = (int) (((int) this.z.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.G);
        }
        this.r.g(formCard.titleInfo);
        this.s.g(formCard.commitInfo);
        d.a.j0.s2.z.b.a().b(new d.a.j0.s2.z.a(this.s.getPostUrl()));
        V();
        X();
        W();
        e0(this.r);
        e0(this.s);
        if (formCard.isCommitSuccess()) {
            i0();
        }
        if (formCard.mHasShown) {
            return;
        }
        w.p().m().d(formCard.getShowExtra(), this.f18681e);
        formCard.mHasShown = true;
    }

    public void e0(d dVar) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        d.a.j0.j1.o.k.a.a(this.B, dVar);
    }

    public final void f0() {
        this.u.removeAllViews();
        List<d> list = this.B;
        if (list != null) {
            d.a.j0.j1.o.k.a.c(list);
        } else {
            this.B = new ArrayList();
        }
        this.s.setVisibility(0);
        this.u.setVisibility(0);
        this.t.setVisibility(8);
        this.s.setClickable(true);
        this.v.setImageBitmap(null);
    }

    public final void g0(int i2, int i3) {
        this.E = (this.D * i3) / i2;
        this.y.getLayoutParams().height = this.E;
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        int i4 = this.D;
        layoutParams.width = i4;
        this.G = (float) (i4 / 750.0d);
    }

    public final void h0(FormItemBaseView formItemBaseView, int i2, int i3) {
        if (formItemBaseView != null) {
            if (i2 != i3 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.b());
                layoutParams.bottomMargin = (int) (((int) this.z.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.G);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.b()));
        }
    }

    public final void i0() {
        this.s.setVisibility(4);
        this.u.setVisibility(4);
        this.t.setVisibility(0);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.y = inflate;
        this.r = (TitleView) inflate.findViewById(R.id.form_title_view);
        ImageView imageView = (ImageView) this.y.findViewById(R.id.tb_img_background);
        this.v = imageView;
        imageView.setEnabled(false);
        this.s = (CommitView) this.y.findViewById(R.id.form_commit_view);
        this.u = (LinearLayout) this.y.findViewById(R.id.item_content_view);
        this.t = (LinearLayout) this.y.findViewById(R.id.form_commit_success_view);
        this.w = (TextView) this.y.findViewById(R.id.form_success_title);
        this.x = (TextView) this.y.findViewById(R.id.form_success_desc);
        a0();
        return this.y;
    }
}
