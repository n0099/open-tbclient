package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.q0.s.q.e1;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.u.f.g0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e1 f52427a;

    /* renamed from: b  reason: collision with root package name */
    public e1 f52428b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f52429c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f52430d;

    /* renamed from: e  reason: collision with root package name */
    public int f52431e;

    /* renamed from: f  reason: collision with root package name */
    public g0 f52432f;

    /* renamed from: g  reason: collision with root package name */
    public b f52433g;
    public LinearLayout game_info;
    public ImageView game_info_img;
    public TextView game_info_text;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f52434h;
    public LinearLayout news_info;
    public ImageView news_info_img;
    public TextView news_info_text;
    public View pb_list_item_top_line;
    public View pb_news_info_divider;
    public LinearLayout pb_news_info_layout;
    public RelativeLayout pb_top_code;
    public TextView top_code_detail_subtitle_text;
    public TextView top_code_detail_summary_text;
    public TextView top_code_get_btn;
    public TbImageView top_code_img;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbPageNewsInfoHolder f52435e;

        public a(PbPageNewsInfoHolder pbPageNewsInfoHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbPageNewsInfoHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52435e = pbPageNewsInfoHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f52435e.f52430d.getPageActivity()) && l.D()) {
                if (this.f52435e.f52433g != null) {
                    this.f52435e.f52433g.a(this.f52435e.f52432f);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.f52435e;
                if (view == pbPageNewsInfoHolder.pb_top_code) {
                    if (pbPageNewsInfoHolder.f52427a == null || TextUtils.isEmpty(this.f52435e.f52427a.f13288a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f52435e.f52430d.getPageActivity()), new String[]{this.f52435e.f52427a.f13288a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.f52435e.f52427a.f13288a));
                } else if (view == pbPageNewsInfoHolder.news_info) {
                    BdLog.e("link: " + this.f52435e.f52428b.f13288a);
                    if (this.f52435e.f52428b == null || TextUtils.isEmpty(this.f52435e.f52428b.f13288a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f52435e.f52430d.getPageActivity()), new String[]{this.f52435e.f52428b.f13288a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.f52435e.f52428b.f13288a));
                } else if (view != pbPageNewsInfoHolder.game_info || pbPageNewsInfoHolder.f52429c == null || TextUtils.isEmpty(this.f52435e.f52429c.f13288a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f52435e.f52430d.getPageActivity()), new String[]{this.f52435e.f52429c.f13288a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.f52435e.f52429c.f13288a));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(g0 g0Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52431e = 3;
        this.f52434h = new a(this);
        this.f52430d = tbPageContext;
        this.f52433g = bVar;
        this.pb_news_info_layout = (LinearLayout) view.findViewById(i.pb_news_info_layout);
        this.pb_list_item_top_line = view.findViewById(i.pb_list_item_top_line);
        this.pb_top_code = (RelativeLayout) view.findViewById(i.pb_top_code);
        this.top_code_img = (TbImageView) view.findViewById(i.top_code_img);
        this.top_code_get_btn = (TextView) view.findViewById(i.top_code_get_btn);
        this.top_code_detail_summary_text = (TextView) view.findViewById(i.top_code_detail_summary_text);
        this.top_code_detail_subtitle_text = (TextView) view.findViewById(i.top_code_detail_subtitle_text);
        this.news_info = (LinearLayout) view.findViewById(i.news_info);
        this.news_info_img = (ImageView) view.findViewById(i.news_info_img);
        this.news_info_text = (TextView) view.findViewById(i.news_info_text);
        this.game_info = (LinearLayout) view.findViewById(i.game_info);
        this.game_info_img = (ImageView) view.findViewById(i.game_info_img);
        this.game_info_text = (TextView) view.findViewById(i.game_info_text);
        this.pb_news_info_divider = view.findViewById(i.pb_news_info_divider);
        setOnClickListener(this.f52434h);
    }

    public void bindDataToView(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g0Var) == null) || g0Var == null) {
            return;
        }
        this.f52432f = g0Var;
        e1 e1Var = g0Var.G0;
        this.f52427a = e1Var;
        this.f52428b = g0Var.H0;
        this.f52429c = g0Var.I0;
        if (e1Var != null) {
            this.top_code_img.startLoad(e1Var.f13291d, 10, false);
            this.top_code_detail_summary_text.setText(this.f52427a.f13289b);
            this.top_code_detail_subtitle_text.setText(this.f52427a.f13292e);
            this.top_code_get_btn.setText(this.f52427a.f13293f);
            SkinManager.setBackgroundResource(this.top_code_get_btn, h.selector_star_btn_like);
            SkinManager.setViewTextColor(this.top_code_get_btn, h.news_text_color_selector);
        } else {
            this.pb_top_code.setVisibility(8);
        }
        e1 e1Var2 = this.f52428b;
        if (e1Var2 != null) {
            this.news_info_text.setText(e1Var2.f13289b);
            SkinManager.setBackgroundResource(this.news_info_img, h.icon_frs_news);
        } else {
            this.news_info.setVisibility(8);
            this.news_info_text.setVisibility(8);
            this.news_info_img.setVisibility(8);
        }
        e1 e1Var3 = this.f52429c;
        if (e1Var3 != null) {
            this.game_info_text.setText(e1Var3.f13289b);
            SkinManager.setBackgroundResource(this.game_info_img, h.icon_frs_game);
        } else {
            this.game_info.setVisibility(8);
            this.game_info_text.setVisibility(8);
            this.game_info_text.setVisibility(8);
        }
        this.pb_news_info_layout.setTag(g0Var);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f52431e == i2) {
            return;
        }
        this.f52430d.getLayoutMode().k(i2 == 1);
        this.f52430d.getLayoutMode().j(getView());
        this.f52431e = i2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.pb_top_code.setOnClickListener(onClickListener);
            this.news_info.setOnClickListener(onClickListener);
            this.game_info.setOnClickListener(onClickListener);
        }
    }
}
