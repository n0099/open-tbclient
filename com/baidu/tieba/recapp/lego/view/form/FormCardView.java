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
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.fo;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.jd7;
import com.repackage.kd7;
import com.repackage.ma8;
import com.repackage.oi;
import com.repackage.pa8;
import com.repackage.qa8;
import com.repackage.rk4;
import com.repackage.zt4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext A;
    public float B;
    public TitleView m;
    public CommitView n;
    public LinearLayout o;
    public LinearLayout p;
    public ImageView q;
    public TextView r;
    public TextView s;
    public View t;
    public Activity u;
    public FormCard v;
    public List<d> w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FormCardView a;

        public a(FormCardView formCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {formCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = formCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FormCardView formCardView = this.a;
                formCardView.S(formCardView.w, this.a.n.getPostUrl(), this.a.x);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FormCardView a;

        public b(FormCardView formCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {formCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = formCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((b) foVar, str, i);
                if (foVar != null) {
                    try {
                        if (foVar.p() != null) {
                            int height = foVar.p().getHeight();
                            int width = foVar.p().getWidth();
                            if (width == 0) {
                                return;
                            }
                            int i2 = (this.a.y * height) / width;
                            int i3 = this.a.v.backgroundInfo.c;
                            if (i3 == 1) {
                                this.a.q.getLayoutParams().width = this.a.y;
                                this.a.q.getLayoutParams().height = i2;
                            } else if (i3 == 2) {
                                this.a.q.getLayoutParams().width = this.a.y;
                                this.a.q.getLayoutParams().height = this.a.z;
                            }
                            int b = kd7.b(this.a.v.backgroundInfo.b);
                            if (!kd7.a(b)) {
                                this.a.t.setBackgroundColor(b);
                            }
                            foVar.h(this.a.q);
                            return;
                        }
                    } catch (Exception unused) {
                        this.a.q.setImageBitmap(null);
                        this.a.q.setVisibility(8);
                        return;
                    } catch (OutOfMemoryError unused2) {
                        this.a.q.setImageBitmap(null);
                        this.a.q.setVisibility(8);
                        return;
                    }
                }
                this.a.q.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FormCardView a;

        public c(FormCardView formCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {formCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = formCardView;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof rk4) {
                    rk4 rk4Var = (rk4) obj;
                    if (rk4Var.a) {
                        this.a.v.setCommitState(true);
                        this.a.a0();
                    } else if (!TextUtils.isEmpty(rk4Var.c)) {
                        new zt4().b(rk4Var.c);
                        this.a.v.setCommitState(false);
                    } else {
                        new zt4().d(R.drawable.obfuscated_res_0x7f080a6a, R.string.obfuscated_res_0x7f0f0642);
                        this.a.v.setCommitState(false);
                    }
                }
                this.a.n.setClickable(true);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = "";
        this.y = 0;
        this.z = 0;
        this.B = 1.0f;
        this.A = tbPageContext;
        this.u = tbPageContext.getPageActivity();
        this.y = oi.k(TbadkCoreApplication.getInst());
    }

    public final JSONObject M(String str, String str2) {
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void N(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) {
            if (TextUtils.isEmpty(str)) {
                this.n.setClickable(true);
            } else {
                qa8.a().d(null, str, hashMap, new c(this));
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.setBackgroundResource(R.drawable.obfuscated_res_0x7f08057c);
            if (this.v.backgroundInfo != null) {
                this.q.setVisibility(0);
                if (!TextUtils.isEmpty(this.v.backgroundInfo.a)) {
                    ig.h().m(this.v.backgroundInfo.a, 10, new b(this), this.A.getUniqueId());
                    return;
                }
            }
            this.q.setVisibility(8);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FormCard.f fVar = this.v.resultInfo;
            float dimension = this.i.getResources().getDimension(R.dimen.obfuscated_res_0x7f070336);
            float dimension2 = this.i.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b5);
            int color = this.i.getResources().getColor(R.color.obfuscated_res_0x7f06071e);
            if (fVar != null) {
                this.r.setText(fVar.a);
                this.r.setTextColor(-1);
                this.r.setTextSize(0, dimension);
                this.s.setText(fVar.b);
                this.s.setTextColor(color);
                this.s.setTextSize(0, dimension2);
            }
        }
    }

    public final void Q() {
        List<FormCard.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.v.itemList) == null || list.size() <= 0) {
            return;
        }
        int size = this.v.itemList.size();
        for (int i = 0; i < size; i++) {
            FormCard.b bVar = this.v.itemList.get(i);
            if (bVar != null) {
                switch (bVar.a) {
                    case 1:
                        R(bVar, new TitleView(this.u), i, size);
                        continue;
                    case 2:
                        R(bVar, new CommitView(this.u), i, size);
                        continue;
                    case 3:
                    case 4:
                    case 5:
                        R(bVar, new EditView(this.u), i, size);
                        continue;
                    case 6:
                    case 7:
                    case 8:
                        R(bVar, new PickerView(this.u), i, size);
                        continue;
                }
            }
        }
    }

    public final void R(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, bVar, formItemBaseView, i, i2) == null) {
            formItemBaseView.f(this.B);
            formItemBaseView.g(bVar);
            Z(formItemBaseView, i, i2);
            W(formItemBaseView);
            this.p.addView(formItemBaseView);
        }
    }

    public void S(List<d> list, String str, String str2) {
        JSONObject M;
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
                if (formView2 != null && (M = M(formView2.getTag(), formView2.getResult())) != null) {
                    jSONArray.put(M);
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("commit_content", jSONArray.toString());
            hashMap.put("item_id", str2);
            hashMap.put("url", str);
            N(str, hashMap);
            this.n.setClickable(false);
            return;
        }
        new zt4().d(R.drawable.obfuscated_res_0x7f080a6a, R.string.obfuscated_res_0x7f0f0641);
        this.n.setClickable(true);
    }

    public final void T() {
        CommitView commitView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (commitView = this.n) == null) {
            return;
        }
        commitView.getCommitButton().setOnClickListener(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: U */
    public void u(FormCard formCard, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, formCard, i) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: V */
    public void v(FormCard formCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, formCard) == null) || formCard == null || !formCard.mIsLegal || this.v == formCard) {
            return;
        }
        X();
        this.v = formCard;
        this.x = formCard.getItemId();
        Y(formCard.mWidth, formCard.mHeight);
        this.m.f(this.B);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = (int) (((int) this.u.getApplicationContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070340)) * this.B);
        }
        this.n.f(this.B);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.bottomMargin = (int) (((int) this.u.getApplicationContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070340)) * this.B);
        }
        this.m.g(formCard.titleInfo);
        this.n.g(formCard.commitInfo);
        qa8.a().b(new pa8(this.n.getPostUrl()));
        O();
        Q();
        P();
        W(this.m);
        W(this.n);
        if (formCard.isCommitSuccess()) {
            a0();
        }
        if (formCard.mHasShown) {
            return;
        }
        ma8.q().l().d(formCard.getShowExtra(), this.a);
        formCard.mHasShown = true;
    }

    public void W(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            if (this.w == null) {
                this.w = new ArrayList();
            }
            jd7.a(this.w, dVar);
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.p.removeAllViews();
            List<d> list = this.w;
            if (list != null) {
                jd7.c(list);
            } else {
                this.w = new ArrayList();
            }
            this.n.setVisibility(0);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setClickable(true);
            this.q.setImageBitmap(null);
        }
    }

    public final void Y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.z = (this.y * i2) / i;
            this.t.getLayoutParams().height = this.z;
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            int i3 = this.y;
            layoutParams.width = i3;
            this.B = (float) (i3 / 750.0d);
        }
    }

    public final void Z(FormItemBaseView formItemBaseView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048589, this, formItemBaseView, i, i2) == null) || formItemBaseView == null) {
            return;
        }
        if (i != i2 - 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.b());
            layoutParams.bottomMargin = (int) (((int) this.u.getApplicationContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07033d)) * this.B);
            formItemBaseView.setLayoutParams(layoutParams);
            return;
        }
        formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.b()));
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.n.setVisibility(4);
            this.p.setVisibility(4);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d018a, (ViewGroup) null);
            this.t = inflate;
            this.m = (TitleView) inflate.findViewById(R.id.obfuscated_res_0x7f090a1e);
            ImageView imageView = (ImageView) this.t.findViewById(R.id.obfuscated_res_0x7f091eec);
            this.q = imageView;
            imageView.setEnabled(false);
            this.n = (CommitView) this.t.findViewById(R.id.obfuscated_res_0x7f090a1b);
            this.p = (LinearLayout) this.t.findViewById(R.id.obfuscated_res_0x7f090f5f);
            this.o = (LinearLayout) this.t.findViewById(R.id.obfuscated_res_0x7f090a1a);
            this.r = (TextView) this.t.findViewById(R.id.obfuscated_res_0x7f090a1d);
            this.s = (TextView) this.t.findViewById(R.id.obfuscated_res_0x7f090a1c);
            T();
            return this.t;
        }
        return (View) invokeV.objValue;
    }
}
