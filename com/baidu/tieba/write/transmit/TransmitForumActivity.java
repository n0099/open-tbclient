package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TransmitForumActivity extends BaseActivity<TransmitForumActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FORUM_NUM = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b.a.e.m.e.a> mAdapters;
    public ImageView mBackImageView;
    public View mBackView;
    public List<n> mDataList;
    public TransmitForumAdapter mForumAdapter;
    public View mLayoutOperate;
    public BdTypeListView mListView;
    public View.OnClickListener mOnClickListener;
    public TransmitSelectAdapter mSelectAdapter;
    public View mTopView;
    public TextView mTransmitConfirmButton;
    public b.a.r0.e4.q.a mTransmitForumCallback;
    public TextView mTransmitSubTitle;
    public TextView mTransmitTipsView;
    public TextView mTransmitTitle;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitForumActivity f56765e;

        public a(TransmitForumActivity transmitForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56765e = transmitForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() != this.f56765e.mTransmitConfirmButton.getId()) {
                if (view.getId() == this.f56765e.mBackView.getId() || view.getId() == this.f56765e.mTopView.getId()) {
                    this.f56765e.setResult(0);
                    this.f56765e.startExitAnimation();
                    return;
                }
                return;
            }
            ArrayList<TransmitForumData> selectedList = this.f56765e.getSelectedList();
            Intent intent = new Intent();
            intent.putExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED, this.f56765e.generateSelectResult(selectedList));
            this.f56765e.setResult(-1, intent);
            this.f56765e.startExitAnimation();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.r0.e4.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitForumActivity f56766a;

        public b(TransmitForumActivity transmitForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56766a = transmitForumActivity;
        }

        @Override // b.a.r0.e4.q.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56766a.setTransmitConfirmButtonText();
            }
        }

        @Override // b.a.r0.e4.q.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f56766a.showToast(R.string.transmit_max_commit);
            }
        }

        @Override // b.a.r0.e4.q.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f56766a.getSelectedList()) >= 3 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitForumActivity f56767a;

        public c(TransmitForumActivity transmitForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56767a = transmitForumActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f56767a.finish();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    } catch (JSONException e2) {
                        e2.printStackTrace();
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
                this.mTransmitConfirmButton.setText(getResources().getString(R.string.transmit_confirm, Integer.valueOf(count), 3));
            } else {
                this.mTransmitConfirmButton.setText(getResources().getString(R.string.confirm));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.out_to_bottom);
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
            for (n nVar : this.mDataList) {
                if (nVar instanceof TransmitForumData) {
                    TransmitForumData transmitForumData = (TransmitForumData) nVar;
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 25005) {
                HotTopicBussinessData q0 = this.mSelectAdapter.q0(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                if (q0 == null) {
                    return;
                }
                for (n nVar : this.mDataList) {
                    if ((nVar instanceof TransmitForumData) && TextUtils.equals(q0.mForumName, ((TransmitForumData) nVar).forumName)) {
                        return;
                    }
                }
                if (this.mTransmitForumCallback.c()) {
                    List<n> list = this.mDataList;
                    list.add(list.size() - 1, new TransmitForumData(q0.mForumId, q0.mForumName, false, 0));
                    showToast(R.string.transmit_max_commit);
                } else {
                    List<n> list2 = this.mDataList;
                    list2.add(list2.size() - 1, new TransmitForumData(q0.mForumId, q0.mForumName, true, 0));
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
            setContentView(R.layout.transmit_forum_activity);
            View findViewById = findViewById(R.id.trasmit_back);
            this.mBackView = findViewById;
            findViewById.setOnClickListener(this.mOnClickListener);
            this.mTransmitConfirmButton = (TextView) findViewById(R.id.transmit_cofirm);
            this.mTransmitTitle = (TextView) findViewById(R.id.transmit_title);
            this.mTransmitSubTitle = (TextView) findViewById(R.id.transmit_subtitle);
            this.mBackImageView = (ImageView) findViewById(R.id.trasmit_back);
            this.mTransmitConfirmButton.setOnClickListener(this.mOnClickListener);
            this.mListView = (BdTypeListView) findViewById(R.id.trasmit_grid_view);
            this.mListView.setMaxHeight(l.i(getPageContext().getPageActivity()) - getResources().getDimensionPixelSize(R.dimen.ds568));
            this.mListView.setOverScrollMode(2);
            this.mTransmitTipsView = (TextView) findViewById(R.id.transmit_subtitle);
            this.mDataList = new ArrayList();
            if (getIntent() != null) {
                arrayList = getIntent().getParcelableArrayListExtra(TransmitForumActivityConfig.KEY_RECOMMEND_FORUM_LIST);
                if (ListUtils.getCount(arrayList) > 0) {
                    TransmitForumData transmitForumData = (TransmitForumData) arrayList.get(0);
                    if (transmitForumData != null) {
                        if (transmitForumData.checked) {
                            this.mTransmitTipsView.setText(R.string.transmit_forum_publish_more_forum);
                        } else {
                            this.mTransmitTipsView.setText(R.string.transmit_forum_select_more_forum);
                        }
                    }
                    this.mDataList.addAll(arrayList);
                }
            } else {
                arrayList = null;
            }
            this.mDataList.add(new b.a.r0.e4.q.c());
            this.mForumAdapter = new TransmitForumAdapter(getPageContext().getPageActivity(), TransmitForumData.ID_TRANSMIT_SELECT_DATA);
            this.mSelectAdapter = new TransmitSelectAdapter(getPageContext().getPageActivity(), b.a.r0.e4.q.c.f17613e, getUniqueId(), arrayList);
            this.mForumAdapter.j0(this.mTransmitForumCallback);
            this.mAdapters.add(this.mForumAdapter);
            this.mAdapters.add(this.mSelectAdapter);
            this.mListView.addAdapters(this.mAdapters);
            this.mListView.setData(this.mDataList);
            setTransmitConfirmButtonText();
            View findViewById2 = findViewById(R.id.view_top);
            this.mTopView = findViewById2;
            findViewById2.setOnClickListener(this.mOnClickListener);
            View findViewById3 = findViewById(R.id.layout_operate);
            this.mLayoutOperate = findViewById3;
            findViewById3.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.in_from_bottom));
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
                transmitSelectAdapter.p0();
            }
        }
    }
}
