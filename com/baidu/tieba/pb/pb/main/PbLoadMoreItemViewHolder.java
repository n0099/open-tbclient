package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19501a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19502b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19503c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f19504d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19505e;

    /* renamed from: f  reason: collision with root package name */
    public View f19506f;

    /* renamed from: g  reason: collision with root package name */
    public String f19507g;

    /* renamed from: h  reason: collision with root package name */
    public int f19508h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19509i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbLoadMoreItemViewHolder f19510a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLoadMoreItemViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19510a = pbLoadMoreItemViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.f19510a.g();
                } else {
                    this.f19510a.b();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLoadMoreItemViewHolder(View view, BdUniqueId bdUniqueId) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, bdUniqueId};
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
        this.f19509i = new a(this, 2921471);
        this.f19501a = view;
        this.f19502b = (LinearLayout) view.findViewById(R.id.pb_more_view);
        this.f19503c = (TextView) view.findViewById(R.id.pb_more_text);
        this.f19505e = (ImageView) this.f19501a.findViewById(R.id.no_data_image);
        this.f19508h = l.g(this.f19501a.getContext(), R.dimen.tbds156);
        this.f19506f = this.f19501a.findViewById(R.id.empty_view);
        this.f19504d = (ProgressBar) view.findViewById(R.id.progress);
        this.f19502b.setVisibility(0);
        this.f19509i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f19509i);
        c();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19504d.setVisibility(8);
            String str = this.f19507g;
            if (str != null) {
                this.f19503c.setText(str);
            } else {
                this.f19503c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.pb_load_more));
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19503c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0109));
            this.f19502b.setBackgroundResource(R.drawable.pb_foot_more_trans_selector);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f19501a.setOnClickListener(onClickListener);
        }
    }

    public void e(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.f19507g = str;
            this.f19503c.setText(str);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19502b.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.bottomMargin = 0;
            this.f19502b.setLayoutParams(layoutParams);
            this.f19505e.setVisibility(8);
            this.f19506f.setVisibility(8);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f19503c.setText(str);
            this.f19505e.setVisibility(0);
            this.f19505e.setImageResource(PbListView.D);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19505e.getLayoutParams();
            layoutParams.topMargin = this.f19508h;
            this.f19505e.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f19506f.getLayoutParams());
            layoutParams2.height = this.f19508h;
            this.f19506f.setLayoutParams(layoutParams2);
            this.f19506f.setVisibility(0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f19504d.setVisibility(0);
            this.f19503c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.loading));
        }
    }
}
