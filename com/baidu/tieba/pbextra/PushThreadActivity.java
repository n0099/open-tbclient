package com.baidu.tieba.pbextra;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.PushStatusData;
import com.baidu.tbadk.core.data.PushTypeData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class PushThreadActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GridView a;
    public int b;
    public PushTypeData c;
    public TextView d;
    public ImageButton e;
    public PushStatusData f;
    public List<PushTypeData> g;
    public HttpMessageListener h;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushThreadActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PushThreadActivity pushThreadActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushThreadActivity, Integer.valueOf(i)};
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
            this.a = pushThreadActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !((z = httpResponsedMessage instanceof PbPushHttpResponseMessage))) {
                return;
            }
            if (httpResponsedMessage.hasError()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e1f);
            } else if (z) {
                if (this.a.b == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                    this.a.setResult(-1, new Intent());
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e1f);
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushThreadActivity a;

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        public b(PushThreadActivity pushThreadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushThreadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushThreadActivity;
            pushThreadActivity.b = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ListUtils.getCount(this.a.g);
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0830, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091202);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091201);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926ff);
                PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.a.g, i);
                if (pushTypeData != null) {
                    tbImageView.N(pushTypeData.getIcon(), 10, false);
                    textView.setText(pushTypeData.getName());
                    if (pushTypeData.getType() == this.a.b) {
                        SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
                        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0308);
                    } else {
                        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                        imageView.setImageDrawable(null);
                    }
                }
                return inflate;
            }
            return (View) invokeILL.objValue;
        }
    }

    public PushThreadActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PushStatusData pushStatusData = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
            this.f = pushStatusData;
            if (pushStatusData != null) {
                this.g = pushStatusData.getPushTypeDatas();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            initData();
            x1();
            this.h.setSelfListener(true);
            registerListener(this.h);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.d) {
                if (this.b == 0) {
                    showToast(R.string.obfuscated_res_0x7f0f132f);
                    return;
                }
                long longExtra = getIntent().getLongExtra("forum_id", 0L);
                long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
                long longExtra3 = getIntent().getLongExtra("user_id", 0L);
                showLoadingDialog("");
                sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.b, longExtra3));
            } else if (view2 == this.e) {
                finish();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091201);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926ff);
            this.d.setEnabled(true);
            PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.g, i);
            if (pushTypeData != null) {
                if (this.b == pushTypeData.getType()) {
                    imageView.setImageDrawable(null);
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                    this.b = -1;
                    return;
                }
                PushTypeData pushTypeData2 = this.c;
                if (pushTypeData2 != null && (childAt = adapterView.getChildAt(ListUtils.getPosition(this.g, pushTypeData2))) != null) {
                    ((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f091201)).setImageDrawable(null);
                    SkinManager.setViewTextColor((TextView) childAt.findViewById(R.id.obfuscated_res_0x7f0926ff), (int) R.color.CAM_X0105);
                }
                SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0308);
                this.b = pushTypeData.getType();
                this.c = pushTypeData;
            }
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0831);
            SkinManager.setBackgroundResource(findViewById(R.id.obfuscated_res_0x7f091dbe), R.drawable.dialog_background);
            SkinManager.setViewTextColor((TextView) findViewById(R.id.obfuscated_res_0x7f09212e), (int) R.color.CAM_X0105);
            this.a = (GridView) findViewById(R.id.obfuscated_res_0x7f090ec9);
            this.a.setAdapter((ListAdapter) new b(this));
            this.a.setOnItemClickListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091da6);
            this.d = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.obfuscated_res_0x7f08125b);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            this.d.setOnClickListener(this);
            ImageButton imageButton = (ImageButton) findViewById(R.id.obfuscated_res_0x7f090fd6);
            this.e = imageButton;
            SkinManager.setBackgroundResource(imageButton, R.drawable.obfuscated_res_0x7f08125a);
            this.e.setOnClickListener(this);
        }
    }
}
