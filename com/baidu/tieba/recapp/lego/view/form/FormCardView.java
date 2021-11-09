package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.a.e;
import b.a.e.e.p.l;
import b.a.q0.c.f;
import b.a.r0.z2.y;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TitleView f53596f;

    /* renamed from: g  reason: collision with root package name */
    public CommitView f53597g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f53598h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f53599i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public View m;
    public Activity n;
    public FormCard o;
    public List<d> p;
    public String q;
    public int r;
    public int s;
    public TbPageContext t;
    public float u;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FormCardView f53600e;

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
            this.f53600e = formCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FormCardView formCardView = this.f53600e;
                formCardView.handlePostData(formCardView.p, this.f53600e.f53597g.getPostUrl(), this.f53600e.q);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FormCardView f53601a;

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
            this.f53601a = formCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
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
                            int i3 = (this.f53601a.r * height) / width;
                            int i4 = this.f53601a.o.backgroundInfo.f53498c;
                            if (i4 == 1) {
                                this.f53601a.j.getLayoutParams().width = this.f53601a.r;
                                this.f53601a.j.getLayoutParams().height = i3;
                            } else if (i4 == 2) {
                                this.f53601a.j.getLayoutParams().width = this.f53601a.r;
                                this.f53601a.j.getLayoutParams().height = this.f53601a.s;
                            }
                            int b2 = b.a.r0.q1.o.k.b.b(this.f53601a.o.backgroundInfo.f53497b);
                            if (!b.a.r0.q1.o.k.b.a(b2)) {
                                this.f53601a.m.setBackgroundColor(b2);
                            }
                            aVar.h(this.f53601a.j);
                            return;
                        }
                    } catch (Exception unused) {
                        this.f53601a.j.setImageBitmap(null);
                        this.f53601a.j.setVisibility(8);
                        return;
                    } catch (OutOfMemoryError unused2) {
                        this.f53601a.j.setImageBitmap(null);
                        this.f53601a.j.setVisibility(8);
                        return;
                    }
                }
                this.f53601a.j.setVisibility(8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FormCardView f53602a;

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
            this.f53602a = formCardView;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    if (fVar.f11969a) {
                        this.f53602a.o.setCommitState(true);
                        this.f53602a.v();
                    } else if (!TextUtils.isEmpty(fVar.f11971c)) {
                        new b.a.q0.s.g0.c().b(fVar.f11971c);
                        this.f53602a.o.setCommitState(false);
                    } else {
                        new b.a.q0.s.g0.c().d(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                        this.f53602a.o.setCommitState(false);
                    }
                }
                this.f53602a.f53597g.setClickable(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        FormItemBaseView getFormView();

        boolean isPrepareToCommit();
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
        this.q = "";
        this.r = 0;
        this.s = 0;
        this.u = 1.0f;
        this.t = tbPageContext;
        this.n = tbPageContext.getPageActivity();
        this.r = l.k(TbadkCoreApplication.getInst());
    }

    public void handlePostData(List<d> list, String str, String str2) {
        JSONObject l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, list, str, str2) == null) || list == null || list.size() < 1) {
            return;
        }
        boolean z = true;
        for (d dVar : list) {
            FormItemBaseView formView = dVar.getFormView();
            if (formView != null) {
                if (!dVar.isPrepareToCommit()) {
                    View frameView = formView.getFrameView();
                    if (frameView != null) {
                        formView.drawBackgroundFrame(frameView, FormItemBaseView.DrawableType.ERROR_FRAME);
                    }
                    z = false;
                } else {
                    View frameView2 = formView.getFrameView();
                    if (frameView2 != null) {
                        formView.drawBackgroundFrame(frameView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                    }
                }
            }
        }
        if (z) {
            JSONArray jSONArray = new JSONArray();
            for (d dVar2 : list) {
                FormItemBaseView formView2 = dVar2.getFormView();
                if (formView2 != null && (l = l(formView2.getTag(), formView2.getResult())) != null) {
                    jSONArray.put(l);
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("commit_content", jSONArray.toString());
            hashMap.put("item_id", str2);
            hashMap.put("url", str);
            m(str, hashMap);
            this.f53597g.setClickable(false);
            return;
        }
        new b.a.q0.s.g0.c().d(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
        this.f53597g.setClickable(true);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
            this.m = inflate;
            this.f53596f = (TitleView) inflate.findViewById(R.id.form_title_view);
            ImageView imageView = (ImageView) this.m.findViewById(R.id.tb_img_background);
            this.j = imageView;
            imageView.setEnabled(false);
            this.f53597g = (CommitView) this.m.findViewById(R.id.form_commit_view);
            this.f53599i = (LinearLayout) this.m.findViewById(R.id.item_content_view);
            this.f53598h = (LinearLayout) this.m.findViewById(R.id.form_commit_success_view);
            this.k = (TextView) this.m.findViewById(R.id.form_success_title);
            this.l = (TextView) this.m.findViewById(R.id.form_success_desc);
            r();
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public final JSONObject l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.equals(str2, FormItemBaseView.defaultContent)) {
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

    public final void m(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hashMap) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f53597g.setClickable(true);
            } else {
                b.a.r0.z2.b0.b.a().d(null, str, hashMap, new c(this));
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.setBackgroundResource(R.drawable.form_defalut_bg_image);
            if (this.o.backgroundInfo != null) {
                this.j.setVisibility(0);
                if (!TextUtils.isEmpty(this.o.backgroundInfo.f53496a)) {
                    b.a.e.e.l.d.h().m(this.o.backgroundInfo.f53496a, 10, new b(this), this.t.getUniqueId());
                    return;
                }
            }
            this.j.setVisibility(8);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FormCard.f fVar = this.o.resultInfo;
            float dimension = this.mContext.getResources().getDimension(R.dimen.fontsize48);
            float dimension2 = this.mContext.getResources().getDimension(R.dimen.fontsize28);
            int color = this.mContext.getResources().getColor(R.color.form_font_color);
            if (fVar != null) {
                this.k.setText(fVar.f53507a);
                this.k.setTextColor(-1);
                this.k.setTextSize(0, dimension);
                this.l.setText(fVar.f53508b);
                this.l.setTextColor(color);
                this.l.setTextSize(0, dimension2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(FormCard formCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, formCard, i2) == null) {
        }
    }

    public final void p() {
        List<FormCard.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.o.itemList) == null || list.size() <= 0) {
            return;
        }
        int size = this.o.itemList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FormCard.b bVar = this.o.itemList.get(i2);
            if (bVar != null) {
                switch (bVar.f53499a) {
                    case 1:
                        q(bVar, new TitleView(this.n), i2, size);
                        continue;
                    case 2:
                        q(bVar, new CommitView(this.n), i2, size);
                        continue;
                    case 3:
                    case 4:
                    case 5:
                        q(bVar, new EditView(this.n), i2, size);
                        continue;
                    case 6:
                    case 7:
                    case 8:
                        q(bVar, new PickerView(this.n), i2, size);
                        continue;
                }
            }
        }
    }

    public final void q(FormCard.b bVar, FormItemBaseView formItemBaseView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048588, this, bVar, formItemBaseView, i2, i3) == null) {
            formItemBaseView.scaleMargin(this.u);
            formItemBaseView.updateView(bVar);
            u(formItemBaseView, i2, i3);
            registerListener(formItemBaseView);
            this.f53599i.addView(formItemBaseView);
        }
    }

    public final void r() {
        CommitView commitView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (commitView = this.f53597g) == null) {
            return;
        }
        commitView.getCommitButton().setOnClickListener(new a(this));
    }

    public void registerListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            if (this.p == null) {
                this.p = new ArrayList();
            }
            b.a.r0.q1.o.k.a.a(this.p, dVar);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f53599i.removeAllViews();
            List<d> list = this.p;
            if (list != null) {
                b.a.r0.q1.o.k.a.c(list);
            } else {
                this.p = new ArrayList();
            }
            this.f53597g.setVisibility(0);
            this.f53599i.setVisibility(0);
            this.f53598h.setVisibility(8);
            this.f53597g.setClickable(true);
            this.j.setImageBitmap(null);
        }
    }

    public final void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            this.s = (this.r * i3) / i2;
            this.m.getLayoutParams().height = this.s;
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            int i4 = this.r;
            layoutParams.width = i4;
            this.u = (float) (i4 / 750.0d);
        }
    }

    public final void u(FormItemBaseView formItemBaseView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048593, this, formItemBaseView, i2, i3) == null) || formItemBaseView == null) {
            return;
        }
        if (i2 != i3 - 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.compoundHeight());
            layoutParams.bottomMargin = (int) (((int) this.n.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.u);
            formItemBaseView.setLayoutParams(layoutParams);
            return;
        }
        formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.compoundHeight()));
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f53597g.setVisibility(4);
            this.f53599i.setVisibility(4);
            this.f53598h.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(FormCard formCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, formCard) == null) || formCard == null || !formCard.mIsLegal || this.o == formCard) {
            return;
        }
        s();
        this.o = formCard;
        this.q = formCard.getItemId();
        t(formCard.mWidth, formCard.mHeight);
        this.f53596f.scaleMargin(this.u);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f53596f.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = (int) (((int) this.n.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.u);
        }
        this.f53597g.scaleMargin(this.u);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f53597g.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.bottomMargin = (int) (((int) this.n.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.u);
        }
        this.f53596f.updateView(formCard.titleInfo);
        this.f53597g.updateView(formCard.commitInfo);
        b.a.r0.z2.b0.b.a().b(new b.a.r0.z2.b0.a(this.f53597g.getPostUrl()));
        n();
        p();
        o();
        registerListener(this.f53596f);
        registerListener(this.f53597g);
        if (formCard.isCommitSuccess()) {
            v();
        }
        if (formCard.mHasShown) {
            return;
        }
        y.o().l().d(formCard.getShowExtra(), this.mFrom);
        formCard.mHasShown = true;
    }
}
