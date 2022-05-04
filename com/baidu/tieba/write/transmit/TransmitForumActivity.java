package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ho;
import com.repackage.j09;
import com.repackage.l09;
import com.repackage.oi;
import com.repackage.uo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FORUM_NUM = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ho> mAdapters;
    public ImageView mBackImageView;
    public View mBackView;
    public List<uo> mDataList;
    public TransmitForumAdapter mForumAdapter;
    public View mLayoutOperate;
    public BdTypeListView mListView;
    public View.OnClickListener mOnClickListener;
    public TransmitSelectAdapter mSelectAdapter;
    public View mTopView;
    public TextView mTransmitConfirmButton;
    public j09 mTransmitForumCallback;
    public TextView mTransmitSubTitle;
    public TextView mTransmitTipsView;
    public TextView mTransmitTitle;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitForumActivity a;

        public a(TransmitForumActivity transmitForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2.getId() != this.a.mTransmitConfirmButton.getId()) {
                if (view2.getId() == this.a.mBackView.getId() || view2.getId() == this.a.mTopView.getId()) {
                    this.a.setResult(0);
                    this.a.startExitAnimation();
                    return;
                }
                return;
            }
            ArrayList<TransmitForumData> selectedList = this.a.getSelectedList();
            Intent intent = new Intent();
            intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, this.a.generateSelectResult(selectedList));
            this.a.setResult(-1, intent);
            this.a.startExitAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements j09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitForumActivity a;

        public b(TransmitForumActivity transmitForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitForumActivity;
        }

        @Override // com.repackage.j09
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTransmitConfirmButtonText();
            }
        }

        @Override // com.repackage.j09
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f141d);
            }
        }

        @Override // com.repackage.j09
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.a.getSelectedList()) >= 3 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitForumActivity a;

        public c(TransmitForumActivity transmitForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitForumActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.finish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    public TransmitForumActivity() {
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
        this.mAdapters = new ArrayList();
        this.mOnClickListener = new a(this);
        this.mTransmitForumCallback = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateSelectResult(List<TransmitForumData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (TransmitForumData transmitForumData : list) {
                if (transmitForumData != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(String.valueOf(transmitForumData.forumId), transmitForumData.type);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransmitConfirmButtonText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int count = ListUtils.getCount(getSelectedList());
            if (count > 0) {
                this.mTransmitConfirmButton.setText(getResources().getString(R.string.obfuscated_res_0x7f0f141a, Integer.valueOf(count), 3));
            } else {
                this.mTransmitConfirmButton.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0421));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.obfuscated_res_0x7f0100b5);
            loadAnimation.setAnimationListener(new c(this));
            this.mLayoutOperate.startAnimation(loadAnimation);
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

    public ArrayList<TransmitForumData> getSelectedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            for (uo uoVar : this.mDataList) {
                if (uoVar instanceof TransmitForumData) {
                    TransmitForumData transmitForumData = (TransmitForumData) uoVar;
                    if (transmitForumData.checked) {
                        arrayList.add(transmitForumData);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25005) {
                HotTopicBussinessData j0 = this.mSelectAdapter.j0(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                if (j0 == null) {
                    return;
                }
                for (uo uoVar : this.mDataList) {
                    if ((uoVar instanceof TransmitForumData) && TextUtils.equals(j0.mForumName, ((TransmitForumData) uoVar).forumName)) {
                        return;
                    }
                }
                if (this.mTransmitForumCallback.c()) {
                    List<uo> list = this.mDataList;
                    list.add(list.size() - 1, new TransmitForumData(j0.mForumId, j0.mForumName, false, 0));
                    showToast(R.string.obfuscated_res_0x7f0f141d);
                } else {
                    List<uo> list2 = this.mDataList;
                    list2.add(list2.size() - 1, new TransmitForumData(j0.mForumId, j0.mForumName, true, 0));
                }
                setTransmitConfirmButtonText();
                this.mListView.setData(this.mDataList);
                this.mListView.setSelection(this.mDataList.size() - 1);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setResult(0);
            startExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0844);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092132);
            this.mBackView = findViewById;
            findViewById.setOnClickListener(this.mOnClickListener);
            this.mTransmitConfirmButton = (TextView) findViewById(R.id.obfuscated_res_0x7f09212c);
            this.mTransmitTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f092131);
            this.mTransmitSubTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f092130);
            this.mBackImageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f092132);
            this.mTransmitConfirmButton.setOnClickListener(this.mOnClickListener);
            this.mListView = (BdTypeListView) findViewById(R.id.obfuscated_res_0x7f092133);
            this.mListView.setMaxHeight(oi.i(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e3));
            this.mListView.setOverScrollMode(2);
            this.mTransmitTipsView = (TextView) findViewById(R.id.obfuscated_res_0x7f092130);
            this.mDataList = new ArrayList();
            if (getIntent() != null) {
                arrayList = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
                if (ListUtils.getCount(arrayList) > 0) {
                    TransmitForumData transmitForumData = (TransmitForumData) arrayList.get(0);
                    if (transmitForumData != null) {
                        if (transmitForumData.checked) {
                            this.mTransmitTipsView.setText(R.string.obfuscated_res_0x7f0f141b);
                        } else {
                            this.mTransmitTipsView.setText(R.string.obfuscated_res_0x7f0f141c);
                        }
                    }
                    this.mDataList.addAll(arrayList);
                }
            } else {
                arrayList = null;
            }
            this.mDataList.add(new l09());
            this.mForumAdapter = new TransmitForumAdapter(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
            this.mSelectAdapter = new TransmitSelectAdapter(getPageContext().getPageActivity(), l09.a, getUniqueId(), arrayList);
            this.mForumAdapter.c0(this.mTransmitForumCallback);
            this.mAdapters.add(this.mForumAdapter);
            this.mAdapters.add(this.mSelectAdapter);
            this.mListView.a(this.mAdapters);
            this.mListView.setData(this.mDataList);
            setTransmitConfirmButtonText();
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0923bb);
            this.mTopView = findViewById2;
            findViewById2.setOnClickListener(this.mOnClickListener);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f0911e5);
            this.mLayoutOperate = findViewById3;
            findViewById3.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.obfuscated_res_0x7f01008a));
            SkinManager.setBackgroundColor(this.mLayoutOperate, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.mTransmitConfirmButton, R.drawable.btn_all_blue);
            SkinManager.setViewTextColor(this.mTransmitConfirmButton, R.color.CAM_X0111, 1);
            SkinManager.setImageResource(this.mBackImageView, R.drawable.icon_pb_post_close_n);
            SkinManager.setViewTextColor(this.mTransmitTitle, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.mTransmitSubTitle, R.color.CAM_X0109, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            TransmitSelectAdapter transmitSelectAdapter = this.mSelectAdapter;
            if (transmitSelectAdapter != null) {
                transmitSelectAdapter.i0();
            }
        }
    }
}
