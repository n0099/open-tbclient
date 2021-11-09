package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.q0.s.q.a1;
import b.a.q0.s.q.f1;
import b.a.r0.k2.f;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
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
import java.util.List;
/* loaded from: classes9.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52438a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f52439b;

    /* renamed from: c  reason: collision with root package name */
    public b f52440c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f52441d;
    public View devider;
    public TextView novelAuthor;
    public TbImageView novelCover;
    public TextView novelReadBtn;
    public TextView novelReadNumber;
    public TbImageView novelSubscription;
    public TextView novelTitle;
    public LinearLayout recommendNovelItem;
    public TextView recommendOptionBtn;
    public TextView recommendTitle;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbRecommendNovelHolder f52442e;

        public a(PbRecommendNovelHolder pbRecommendNovelHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbRecommendNovelHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52442e = pbRecommendNovelHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f52442e.f52438a.getPageActivity()) && l.D() && this.f52442e.f52439b != null && !StringUtils.isNull(this.f52442e.f52439b.J0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.L(this.f52442e.f52438a.getPageActivity(), b.a.r0.k2.l.book_plugin_not_install_tip);
                    return;
                }
                if (this.f52442e.f52440c != null) {
                    this.f52442e.f52440c.a(this.f52442e.f52439b);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = this.f52442e;
                if (view == pbRecommendNovelHolder.novelReadBtn) {
                    String str = pbRecommendNovelHolder.f52439b.J0;
                    a1 a1Var = new a1();
                    TbPageContext tbPageContext = (TbPageContext) j.a(this.f52442e.f52438a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, a1Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f52442e.f52439b.J0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.recommendNovelItem) {
                    this.f52442e.f52438a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(this.f52442e.f52438a.getPageActivity(), this.f52442e.f52439b.J0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f52442e.f52439b.J0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.recommendOptionBtn || StringUtils.isNull(pbRecommendNovelHolder.f52439b.I0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f52442e.f52438a.getPageActivity()), new String[]{this.f52442e.f52439b.I0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f52442e.f52439b.J0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(f1 f1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, b bVar) {
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
        this.f52441d = new a(this);
        this.f52438a = tbPageContext;
        this.f52440c = bVar;
        this.recommendTitle = (TextView) view.findViewById(i.textview_recommend_title);
        this.recommendOptionBtn = (TextView) view.findViewById(i.textview_recommend_option_btn);
        this.novelCover = (TbImageView) view.findViewById(i.novel_cover);
        this.novelTitle = (TextView) view.findViewById(i.novel_title);
        this.novelAuthor = (TextView) view.findViewById(i.novel_author);
        this.novelReadNumber = (TextView) view.findViewById(i.novel_read_number);
        this.novelReadBtn = (TextView) view.findViewById(i.novel_read_btn);
        this.recommendNovelItem = (LinearLayout) view.findViewById(i.novel_recommend_item_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(i.novel_subscription);
        this.novelSubscription = tbImageView;
        tbImageView.setDefaultResource(h.transparent_bg);
        this.novelSubscription.setDefaultBgResource(h.transparent_bg);
        this.devider = view.findViewById(i.recommend_devider);
        this.novelReadBtn.setOnClickListener(this.f52441d);
        this.recommendNovelItem.setOnClickListener(this.f52441d);
        this.recommendOptionBtn.setOnClickListener(this.f52441d);
    }

    public void bindDataToView(f1 f1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, f1Var) == null) || f1Var == null) {
            return;
        }
        this.f52439b = f1Var;
        this.recommendTitle.setText(f1Var.G0);
        this.recommendOptionBtn.setText(f1Var.H0);
        this.novelSubscription.startLoad(f1Var.O0, 10, false);
        this.novelCover.startLoad(f1Var.K0, 10, false);
        this.novelReadBtn.setText(f1Var.N0);
        this.novelTitle.setText(f1Var.L0);
        List<String> list = f1Var.M0;
        if (list != null) {
            int size = list.size();
            if (size != 1) {
                if (size == 2) {
                    if (list.get(0) != null) {
                        this.novelAuthor.setText(list.get(0));
                    }
                    if (list.get(1) != null) {
                        this.novelReadNumber.setText(list.get(1));
                    }
                }
            } else if (list.get(0) != null) {
                this.novelAuthor.setText(list.get(0));
            }
        }
        SkinManager.setViewTextColor(this.recommendTitle, f.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.recommendOptionBtn, f.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.novelTitle, f.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.novelAuthor, f.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.novelReadNumber, f.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.novelReadBtn, f.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.devider, f.CAM_X0204);
        SkinManager.setBackgroundResource(this.novelReadBtn, h.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.f52439b.J0));
    }
}
