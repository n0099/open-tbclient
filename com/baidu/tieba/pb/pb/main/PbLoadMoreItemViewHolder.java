package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.u2.f;
import c.a.u0.u2.g;
import c.a.u0.u2.h;
import c.a.u0.u2.i;
import c.a.u0.u2.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f46756b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46757c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f46758d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f46759e;

    /* renamed from: f  reason: collision with root package name */
    public View f46760f;

    /* renamed from: g  reason: collision with root package name */
    public String f46761g;

    /* renamed from: h  reason: collision with root package name */
    public int f46762h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f46763i;

    /* loaded from: classes13.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLoadMoreItemViewHolder a;

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
            this.a = pbLoadMoreItemViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.startLoadData();
                } else {
                    this.a.endLoadData();
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
        this.f46763i = new a(this, 2921471);
        this.a = view;
        this.f46756b = (LinearLayout) view.findViewById(i.pb_more_view);
        this.f46757c = (TextView) view.findViewById(i.pb_more_text);
        this.f46759e = (ImageView) this.a.findViewById(i.no_data_image);
        this.f46762h = n.f(this.a.getContext(), g.tbds156);
        this.f46760f = this.a.findViewById(i.empty_view);
        this.f46758d = (ProgressBar) view.findViewById(i.progress);
        this.f46756b.setVisibility(0);
        this.f46763i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f46763i);
        onChangeSkinType();
    }

    public void endLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f46758d.setVisibility(8);
            String str = this.f46761g;
            if (str != null) {
                this.f46757c.setText(str);
            } else {
                this.f46757c.setText(TbadkCoreApplication.getInst().getContext().getText(l.pb_load_more));
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f46757c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), f.CAM_X0109));
            this.f46756b.setBackgroundResource(h.pb_foot_more_trans_selector);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.f46761g = str;
            this.f46757c.setText(str);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f46756b.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.bottomMargin = 0;
            this.f46756b.setLayoutParams(layoutParams);
            this.f46759e.setVisibility(8);
            this.f46760f.setVisibility(8);
        }
    }

    public void setTextWithNoDataImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f46757c.setText(str);
            this.f46759e.setVisibility(0);
            this.f46759e.setImageResource(PbListView.H);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f46759e.getLayoutParams();
            layoutParams.topMargin = this.f46762h;
            this.f46759e.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f46760f.getLayoutParams());
            layoutParams2.height = this.f46762h;
            this.f46760f.setLayoutParams(layoutParams2);
            this.f46760f.setVisibility(0);
        }
    }

    public void startLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f46758d.setVisibility(0);
            this.f46757c.setText(TbadkCoreApplication.getInst().getContext().getText(l.loading));
        }
    }
}
