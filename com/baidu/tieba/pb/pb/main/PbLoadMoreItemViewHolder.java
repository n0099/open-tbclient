package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
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
/* loaded from: classes9.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f52405a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f52406b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52407c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f52408d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52409e;

    /* renamed from: f  reason: collision with root package name */
    public View f52410f;

    /* renamed from: g  reason: collision with root package name */
    public String f52411g;

    /* renamed from: h  reason: collision with root package name */
    public int f52412h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f52413i;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbLoadMoreItemViewHolder f52414a;

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
            this.f52414a = pbLoadMoreItemViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.f52414a.startLoadData();
                } else {
                    this.f52414a.endLoadData();
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
        this.f52413i = new a(this, 2921471);
        this.f52405a = view;
        this.f52406b = (LinearLayout) view.findViewById(i.pb_more_view);
        this.f52407c = (TextView) view.findViewById(i.pb_more_text);
        this.f52409e = (ImageView) this.f52405a.findViewById(i.no_data_image);
        this.f52412h = l.g(this.f52405a.getContext(), g.tbds156);
        this.f52410f = this.f52405a.findViewById(i.empty_view);
        this.f52408d = (ProgressBar) view.findViewById(i.progress);
        this.f52406b.setVisibility(0);
        this.f52413i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f52413i);
        onChangeSkinType();
    }

    public void endLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52408d.setVisibility(8);
            String str = this.f52411g;
            if (str != null) {
                this.f52407c.setText(str);
            } else {
                this.f52407c.setText(TbadkCoreApplication.getInst().getContext().getText(b.a.r0.k2.l.pb_load_more));
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f52407c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), f.CAM_X0109));
            this.f52406b.setBackgroundResource(h.pb_foot_more_trans_selector);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f52405a.setOnClickListener(onClickListener);
        }
    }

    public void setText(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.f52411g = str;
            this.f52407c.setText(str);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52406b.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.bottomMargin = 0;
            this.f52406b.setLayoutParams(layoutParams);
            this.f52409e.setVisibility(8);
            this.f52410f.setVisibility(8);
        }
    }

    public void setTextWithNoDataImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f52407c.setText(str);
            this.f52409e.setVisibility(0);
            this.f52409e.setImageResource(PbListView.G);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52409e.getLayoutParams();
            layoutParams.topMargin = this.f52412h;
            this.f52409e.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f52410f.getLayoutParams());
            layoutParams2.height = this.f52412h;
            this.f52410f.setLayoutParams(layoutParams2);
            this.f52410f.setVisibility(0);
        }
    }

    public void startLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f52408d.setVisibility(0);
            this.f52407c.setText(TbadkCoreApplication.getInst().getContext().getText(b.a.r0.k2.l.loading));
        }
    }
}
