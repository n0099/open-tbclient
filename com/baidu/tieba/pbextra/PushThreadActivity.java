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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushThreadActivity f19925a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PushThreadActivity pushThreadActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushThreadActivity, Integer.valueOf(i2)};
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
            this.f19925a = pushThreadActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && ((z = httpResponsedMessage instanceof PbPushHttpResponseMessage))) {
                if (httpResponsedMessage.hasError()) {
                    this.f19925a.showToast(R.string.neterror);
                } else if (z) {
                    if (this.f19925a.mCurrentPushType == ((PbPushHttpResponseMessage) httpResponsedMessage).getPushType()) {
                        this.f19925a.setResult(-1, new Intent());
                    } else {
                        this.f19925a.showToast(R.string.neterror);
                    }
                    this.f19925a.finish();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushThreadActivity f19926e;

        public b(PushThreadActivity pushThreadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushThreadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19926e = pushThreadActivity;
            pushThreadActivity.mCurrentPushType = 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f19926e.mPushTypeDatas) : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
                View inflate = LayoutInflater.from(this.f19926e.getPageContext().getPageActivity()).inflate(R.layout.push_thread_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_item_icon);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_item_hint);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_item_title);
                PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.f19926e.mPushTypeDatas, i2);
                if (pushTypeData != null) {
                    tbImageView.M(pushTypeData.getIcon(), 10, false);
                    textView.setText(pushTypeData.getName());
                    if (pushTypeData.getType() == this.f19926e.mCurrentPushType) {
                        SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0308);
                    } else {
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            setContentView(R.layout.push_thread_layout);
            SkinManager.setBackgroundResource(findViewById(R.id.push_thread_container), R.drawable.dialog_background);
            SkinManager.setViewTextColor((TextView) findViewById(R.id.select_hint), R.color.CAM_X0105);
            this.mGridView = (GridView) findViewById(R.id.gv_push);
            this.mGridView.setAdapter((ListAdapter) new b(this));
            this.mGridView.setOnItemClickListener(this);
            TextView textView = (TextView) findViewById(R.id.push_commit);
            this.mPushCommit = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.push_commit_selector);
            SkinManager.setViewTextColor(this.mPushCommit, R.color.CAM_X0101);
            this.mPushCommit.setOnClickListener(this);
            ImageButton imageButton = (ImageButton) findViewById(R.id.ib_close);
            this.mIbClose = imageButton;
            SkinManager.setBackgroundResource(imageButton, R.drawable.push_close_selector);
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
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view == this.mPushCommit) {
                if (this.mCurrentPushType == 0) {
                    showToast(R.string.select_category);
                    return;
                }
                long longExtra = getIntent().getLongExtra("forum_id", 0L);
                long longExtra2 = getIntent().getLongExtra("thread_id", 0L);
                long longExtra3 = getIntent().getLongExtra("user_id", 0L);
                showLoadingDialog("");
                sendMessage(new PbPushRequestMessage(longExtra, longExtra2, this.mCurrentPushType, longExtra3));
            } else if (view == this.mIbClose) {
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
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_hint);
            TextView textView = (TextView) view.findViewById(R.id.tv_item_title);
            this.mPushCommit.setEnabled(true);
            PushTypeData pushTypeData = (PushTypeData) ListUtils.getItem(this.mPushTypeDatas, i2);
            if (pushTypeData != null) {
                if (this.mCurrentPushType == pushTypeData.getType()) {
                    imageView.setImageDrawable(null);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    this.mCurrentPushType = -1;
                    return;
                }
                PushTypeData pushTypeData2 = this.mPreSelectData;
                if (pushTypeData2 != null && (childAt = adapterView.getChildAt(ListUtils.getPosition(this.mPushTypeDatas, pushTypeData2))) != null) {
                    ((ImageView) childAt.findViewById(R.id.iv_item_hint)).setImageDrawable(null);
                    SkinManager.setViewTextColor((TextView) childAt.findViewById(R.id.tv_item_title), R.color.CAM_X0105);
                }
                SkinManager.setImageResource(imageView, R.drawable.bg_choose_ok);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0308);
                this.mCurrentPushType = pushTypeData.getType();
                this.mPreSelectData = pushTypeData;
            }
        }
    }
}
