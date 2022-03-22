package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f34963b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34964c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f34965d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f34966e;

    /* renamed from: f  reason: collision with root package name */
    public View f34967f;

    /* renamed from: g  reason: collision with root package name */
    public String f34968g;

    /* renamed from: h  reason: collision with root package name */
    public int f34969h;
    public CustomMessageListener i;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLoadMoreItemViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLoadMoreItemViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.h();
                } else {
                    this.a.c();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this, 2921471);
        this.a = view;
        this.f34963b = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0916f0);
        this.f34964c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0916ed);
        this.f34966e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091583);
        this.f34969h = n.f(this.a.getContext(), R.dimen.tbds156);
        this.f34967f = this.a.findViewById(R.id.obfuscated_res_0x7f0908c1);
        this.f34965d = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f091929);
        this.f34963b.setVisibility(0);
        this.i.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i);
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34965d.setVisibility(8);
            String str = this.f34968g;
            if (str != null) {
                this.f34964c.setText(str);
            } else {
                this.f34964c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.obfuscated_res_0x7f0f0da7));
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34964c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0109));
            this.f34963b.setBackgroundResource(R.drawable.pb_foot_more_trans_selector);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void f(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            this.f34968g = str;
            this.f34964c.setText(str);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34963b.getLayoutParams();
            layoutParams.height = i;
            layoutParams.bottomMargin = 0;
            this.f34963b.setLayoutParams(layoutParams);
            this.f34966e.setVisibility(8);
            this.f34967f.setVisibility(8);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f34964c.setText(str);
            this.f34966e.setVisibility(0);
            this.f34966e.setImageResource(PbListView.new_pic_emotion_03);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34966e.getLayoutParams();
            layoutParams.topMargin = this.f34969h;
            this.f34966e.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f34967f.getLayoutParams());
            layoutParams2.height = this.f34969h;
            this.f34967f.setLayoutParams(layoutParams2);
            this.f34967f.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f34965d.setVisibility(0);
            this.f34964c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.obfuscated_res_0x7f0f0a2e));
        }
    }
}
