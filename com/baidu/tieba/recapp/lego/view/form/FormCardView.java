package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.l;
import d.a.o0.c.f;
import d.a.p0.w2.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FormCardView f20577e;

        public a(FormCardView formCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {formCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20577e = formCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FormCardView formCardView = this.f20577e;
                formCardView.X(formCardView.B, this.f20577e.s.getPostUrl(), this.f20577e.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FormCardView f20578a;

        public b(FormCardView formCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {formCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20578a = formCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar != null) {
                    try {
                        if (aVar.p() != null) {
                            int height = aVar.p().getHeight();
                            int width = aVar.p().getWidth();
                            if (width == 0) {
                                return;
                            }
                            int i3 = (this.f20578a.D * height) / width;
                            int i4 = this.f20578a.A.backgroundInfo.f20500c;
                            if (i4 == 1) {
                                this.f20578a.v.getLayoutParams().width = this.f20578a.D;
                                this.f20578a.v.getLayoutParams().height = i3;
                            } else if (i4 == 2) {
                                this.f20578a.v.getLayoutParams().width = this.f20578a.D;
                                this.f20578a.v.getLayoutParams().height = this.f20578a.E;
                            }
                            int b2 = d.a.p0.n1.o.k.b.b(this.f20578a.A.backgroundInfo.f20499b);
                            if (!d.a.p0.n1.o.k.b.a(b2)) {
                                this.f20578a.y.setBackgroundColor(b2);
                            }
                            aVar.h(this.f20578a.v);
                            return;
                        }
                    } catch (Exception unused) {
                        this.f20578a.v.setImageBitmap(null);
                        this.f20578a.v.setVisibility(8);
                        return;
                    } catch (OutOfMemoryError unused2) {
                        this.f20578a.v.setImageBitmap(null);
                        this.f20578a.v.setVisibility(8);
                        return;
                    }
                }
                this.f20578a.v.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FormCardView f20579a;

        public c(FormCardView formCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {formCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20579a = formCardView;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    if (fVar.f51836a) {
                        this.f20579a.A.setCommitState(true);
                        this.f20579a.g0();
                    } else if (!TextUtils.isEmpty(fVar.f51838c)) {
                        new d.a.o0.r.f0.c().b(fVar.f51838c);
                        this.f20579a.A.setCommitState(false);
                    } else {
                        new d.a.o0.r.f0.c().d(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                        this.f20579a.A.setCommitState(false);
                    }
                }
                this.f20579a.s.setClickable(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a();

        FormItemBaseView getFormView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C = "";
        this.D = 0;
        this.E = 0;
        this.G = 1.0f;
        this.F = tbPageContext;
        this.z = tbPageContext.getPageActivity();
        this.D = l.k(TbadkCoreApplication.getInst());
    }

    public final JSONObject Q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
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
        return (JSONObject) invokeLL.objValue;
    }

    public final void R(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) {
            if (TextUtils.isEmpty(str)) {
                this.s.setClickable(true);
            } else {
                d.a.p0.w2.z.b.a().d(null, str, hashMap, new c(this));
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.y.setBackgroundResource(R.drawable.form_defalut_bg_image);
            if (this.A.backgroundInfo != null) {
                this.v.setVisibility(0);
                if (!TextUtils.isEmpty(this.A.backgroundInfo.f20498a)) {
                    d.a.c.e.l.d.h().m(this.A.backgroundInfo.f20498a, 10, new b(this), this.F.getUniqueId());
                    return;
                }
            }
            this.v.setVisibility(8);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FormCard.f fVar = this.A.resultInfo;
            float dimension = this.m.getResources().getDimension(R.dimen.fontsize48);
            float dimension2 = this.m.getResources().getDimension(R.dimen.fontsize28);
            int color = this.m.getResources().getColor(R.color.form_font_color);
            if (fVar != null) {
                this.w.setText(fVar.f20509a);
                this.w.setTextColor(-1);
                this.w.setTextSize(0, dimension);
                this.x.setText(fVar.f20510b);
                this.x.setTextColor(color);
                this.x.setTextSize(0, dimension2);
            }
        }
    }

    public final void U() {
        List<FormCard.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.A.itemList) == null || list.size() <= 0) {
            return;
        }
        int size = this.A.itemList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FormCard.b bVar = this.A.itemList.get(i2);
            if (bVar != null) {
                switch (bVar.f20501a) {
                    case 1:
                        W(bVar, new TitleView(this.z), i2, size);
                        continue;
                    case 2:
                        W(bVar, new CommitView(this.z), i2, size);
                        continue;
                    case 3:
                    case 4:
                    case 5:
                        W(bVar, new EditView(this.z), i2, size);
                        continue;
                    case 6:
                    case 7:
                    case 8:
                        W(bVar, new PickerView(this.z), i2, size);
                        continue;
                }
            }
        }
    }

    public final void W(FormCard.b bVar, FormItemBaseView formItemBaseView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, bVar, formItemBaseView, i2, i3) == null) {
            formItemBaseView.f(this.G);
            formItemBaseView.g(bVar);
            f0(formItemBaseView, i2, i3);
            b0(formItemBaseView);
            this.u.addView(formItemBaseView);
        }
    }

    public void X(List<d> list, String str, String str2) {
        JSONObject Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, list, str, str2) == null) || list == null || list.size() < 1) {
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
                if (formView2 != null && (Q = Q(formView2.getTag(), formView2.getResult())) != null) {
                    jSONArray.put(Q);
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("commit_content", jSONArray.toString());
            hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
            hashMap.put("url", str);
            R(str, hashMap);
            this.s.setClickable(false);
            return;
        }
        new d.a.o0.r.f0.c().d(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
        this.s.setClickable(true);
    }

    public final void Y() {
        CommitView commitView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (commitView = this.s) == null) {
            return;
        }
        commitView.getCommitButton().setOnClickListener(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: Z */
    public void v(FormCard formCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, formCard, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a0 */
    public void w(FormCard formCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, formCard) == null) || formCard == null || !formCard.mIsLegal || this.A == formCard) {
            return;
        }
        c0();
        this.A = formCard;
        this.C = formCard.getItemId();
        d0(formCard.mWidth, formCard.mHeight);
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
        d.a.p0.w2.z.b.a().b(new d.a.p0.w2.z.a(this.s.getPostUrl()));
        S();
        U();
        T();
        b0(this.r);
        b0(this.s);
        if (formCard.isCommitSuccess()) {
            g0();
        }
        if (formCard.mHasShown) {
            return;
        }
        w.o().l().d(formCard.getShowExtra(), this.f18230e);
        formCard.mHasShown = true;
    }

    public void b0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            if (this.B == null) {
                this.B = new ArrayList();
            }
            d.a.p0.n1.o.k.a.a(this.B, dVar);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.u.removeAllViews();
            List<d> list = this.B;
            if (list != null) {
                d.a.p0.n1.o.k.a.c(list);
            } else {
                this.B = new ArrayList();
            }
            this.s.setVisibility(0);
            this.u.setVisibility(0);
            this.t.setVisibility(8);
            this.s.setClickable(true);
            this.v.setImageBitmap(null);
        }
    }

    public final void d0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            this.E = (this.D * i3) / i2;
            this.y.getLayoutParams().height = this.E;
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            int i4 = this.D;
            layoutParams.width = i4;
            this.G = (float) (i4 / 750.0d);
        }
    }

    public final void f0(FormItemBaseView formItemBaseView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048589, this, formItemBaseView, i2, i3) == null) || formItemBaseView == null) {
            return;
        }
        if (i2 != i3 - 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.b());
            layoutParams.bottomMargin = (int) (((int) this.z.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.G);
            formItemBaseView.setLayoutParams(layoutParams);
            return;
        }
        formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.b()));
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.s.setVisibility(4);
            this.u.setVisibility(4);
            this.t.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
            Y();
            return this.y;
        }
        return (View) invokeV.objValue;
    }
}
