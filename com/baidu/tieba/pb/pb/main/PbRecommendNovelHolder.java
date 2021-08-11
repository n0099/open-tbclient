package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.o0.s.q.a1;
import c.a.o0.s.q.f1;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54889a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f54890b;

    /* renamed from: c  reason: collision with root package name */
    public b f54891c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f54892d;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbRecommendNovelHolder f54893e;

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
            this.f54893e = pbRecommendNovelHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f54893e.f54889a.getPageActivity()) && l.D() && this.f54893e.f54890b != null && !StringUtils.isNull(this.f54893e.f54890b.G0)) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.L(this.f54893e.f54889a.getPageActivity(), R.string.book_plugin_not_install_tip);
                    return;
                }
                if (this.f54893e.f54891c != null) {
                    this.f54893e.f54891c.a(this.f54893e.f54890b);
                }
                PbRecommendNovelHolder pbRecommendNovelHolder = this.f54893e;
                if (view == pbRecommendNovelHolder.novelReadBtn) {
                    String str = pbRecommendNovelHolder.f54890b.G0;
                    a1 a1Var = new a1();
                    TbPageContext tbPageContext = (TbPageContext) j.a(this.f54893e.f54889a.getPageActivity());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, a1Var));
                    TiebaStatic.log(new StatisticItem("c11387").param("obj_source", 6).param("obj_locate", "0").param("obj_param1", str));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f54893e.f54890b.G0).param("obj_locate", "3"));
                } else if (view == pbRecommendNovelHolder.recommendNovelItem) {
                    this.f54893e.f54889a.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(this.f54893e.f54889a.getPageActivity(), this.f54893e.f54890b.G0)));
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f54893e.f54890b.G0).param("obj_locate", "1"));
                } else if (view != pbRecommendNovelHolder.recommendOptionBtn || StringUtils.isNull(pbRecommendNovelHolder.f54890b.F0)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f54893e.f54889a.getPageActivity()), new String[]{this.f54893e.f54890b.F0});
                    TiebaStatic.log(new StatisticItem("c11442").param("obj_id", this.f54893e.f54890b.G0).param("obj_locate", "2"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f54892d = new a(this);
        this.f54889a = tbPageContext;
        this.f54891c = bVar;
        this.recommendTitle = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.recommendOptionBtn = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.novelCover = (TbImageView) view.findViewById(R.id.novel_cover);
        this.novelTitle = (TextView) view.findViewById(R.id.novel_title);
        this.novelAuthor = (TextView) view.findViewById(R.id.novel_author);
        this.novelReadNumber = (TextView) view.findViewById(R.id.novel_read_number);
        this.novelReadBtn = (TextView) view.findViewById(R.id.novel_read_btn);
        this.recommendNovelItem = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.novelSubscription = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.novelSubscription.setDefaultBgResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.novelReadBtn.setOnClickListener(this.f54892d);
        this.recommendNovelItem.setOnClickListener(this.f54892d);
        this.recommendOptionBtn.setOnClickListener(this.f54892d);
    }

    public void bindDataToView(f1 f1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, f1Var) == null) || f1Var == null) {
            return;
        }
        this.f54890b = f1Var;
        this.recommendTitle.setText(f1Var.D0);
        this.recommendOptionBtn.setText(f1Var.E0);
        this.novelSubscription.startLoad(f1Var.L0, 10, false);
        this.novelCover.startLoad(f1Var.H0, 10, false);
        this.novelReadBtn.setText(f1Var.K0);
        this.novelTitle.setText(f1Var.I0);
        List<String> list = f1Var.J0;
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
        SkinManager.setViewTextColor(this.recommendTitle, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.recommendOptionBtn, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.novelTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.novelAuthor, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.novelReadNumber, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.novelReadBtn, R.color.CAM_X0302, 1);
        SkinManager.setBackgroundColor(this.devider, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.novelReadBtn, R.drawable.btn_pb_novel_recommend_read);
        TiebaStatic.log(new StatisticItem("c11441").param("obj_id", this.f54890b.G0));
    }
}
