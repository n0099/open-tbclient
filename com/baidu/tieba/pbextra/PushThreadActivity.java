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
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes3.dex */
public class PushThreadActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentPushType;
    public GridView mGridView;
    public ImageButton mIbClose;
    public PushTypeData mPreSelectData;
    public TextView mPushCommit;
    public PushStatusData mPushStatusData;
    public HttpMessageListener mPushThreadMessageListener;
    public List<PushTypeData> mPushTypeDatas;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && ((z = httpResponsedMessage instanceof PbPushHttpResponseMessage))) {
                if (httpResponsedMessage.hasError()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                } else if (z) {
                    if (this.a.mCurrentPushType == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        this.a.setResult(-1, new Intent());
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                    }
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushThreadActivity a;

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
            pushThreadActivity.mCurrentPushType = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.a.mPushTypeDatas) : invokeV.intValue;
        }

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

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0700, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090fe5);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090fe4);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092204);
                PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.a.mPushTypeDatas, i);
                if (pushTypeData != null) {
                    tbImageView.K(pushTypeData.getIcon(), 10, false);
                    textView.setText(pushTypeData.getName());
                    if (pushTypeData.getType() == this.a.mCurrentPushType) {
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
        this.mPushThreadMessageListener = new a(this, CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD);
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            PushStatusData pushStatusData = (PushStatusData) getIntent().getSerializableExtra(PushThreadActivityConfig.KEY_PUSH_DATA);
            this.mPushStatusData = pushStatusData;
            if (pushStatusData != null) {
                this.mPushTypeDatas = pushStatusData.getPushTypeDatas();
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0701);
            SkinManager.setBackgroundResource(findViewById(R.id.obfuscated_res_0x7f0919d7), R.drawable.dialog_background);
            SkinManager.setViewTextColor((TextView) findViewById(R.id.obfuscated_res_0x7f091cb1), (int) R.color.CAM_X0105);
            this.mGridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090d01);
            this.mGridView.setAdapter((ListAdapter) new b(this));
            this.mGridView.setOnItemClickListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0919c7);
            this.mPushCommit = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.obfuscated_res_0x7f080fb4);
            SkinManager.setViewTextColor(this.mPushCommit, (int) R.color.CAM_X0101);
            this.mPushCommit.setOnClickListener(this);
            ImageButton imageButton = (ImageButton) findViewById(R.id.obfuscated_res_0x7f090dfa);
            this.mIbClose = imageButton;
            SkinManager.setBackgroundResource(imageButton, R.drawable.obfuscated_res_0x7f080fb3);
            this.mIbClose.setOnClickListener(this);
        }
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

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.mPushCommit) {
                if (this.mCurrentPushType == 0) {
                    showToast(R.string.obfuscated_res_0x7f0f10dc);
                    return;
                }
                long longExtra = getIntent().getLongExtra("forum_id", 0L);
                long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
                long longExtra3 = getIntent().getLongExtra("user_id", 0L);
                showLoadingDialog("");
                sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.mCurrentPushType, longExtra3));
            } else if (view2 == this.mIbClose) {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            initData();
            initUI();
            this.mPushThreadMessageListener.setSelfListener(true);
            registerListener(this.mPushThreadMessageListener);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fe4);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092204);
            this.mPushCommit.setEnabled(true);
            PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.mPushTypeDatas, i);
            if (pushTypeData != null) {
                if (this.mCurrentPushType == pushTypeData.getType()) {
                    imageView.setImageDrawable(null);
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                    this.mCurrentPushType = -1;
                    return;
                }
                PushTypeData pushTypeData2 = this.mPreSelectData;
                if (pushTypeData2 != null && (childAt = adapterView.getChildAt(ListUtils.getPosition(this.mPushTypeDatas, pushTypeData2))) != null) {
                    ((ImageView) childAt.findViewById(R.id.obfuscated_res_0x7f090fe4)).setImageDrawable(null);
                    SkinManager.setViewTextColor((TextView) childAt.findViewById(R.id.obfuscated_res_0x7f092204), (int) R.color.CAM_X0105);
                }
                SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0308);
                this.mCurrentPushType = pushTypeData.getType();
                this.mPreSelectData = pushTypeData;
            }
        }
    }
}
