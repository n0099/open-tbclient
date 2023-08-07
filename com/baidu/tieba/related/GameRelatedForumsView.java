package com.baidu.tieba.related;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.GameData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.f26;
import com.baidu.tieba.h26;
import com.baidu.tieba.om5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class GameRelatedForumsView extends FrameLayout implements h26<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public SelectForumItemAdapter b;
    public LinearLayoutManager c;
    public boolean d;
    public int e;
    public LoadingView f;
    public om5 g;
    public List<SelectForumData> h;
    public int i;
    public HttpMessageListener j;

    @Override // com.baidu.tieba.h26
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRelatedForumsView a;

        public a(GameRelatedForumsView gameRelatedForumsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRelatedForumsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRelatedForumsView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0 && this.a.d && this.a.c.findLastVisibleItemPosition() == this.a.b.getItemCount() - 1) {
                this.a.c(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRelatedForumsView a;

        public b(GameRelatedForumsView gameRelatedForumsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRelatedForumsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRelatedForumsView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.c(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRelatedForumsView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GameRelatedForumsView gameRelatedForumsView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRelatedForumsView, Integer.valueOf(i)};
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
            this.a = gameRelatedForumsView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.j();
                if (httpResponsedMessage.getError() != 0) {
                    if (ListUtils.isEmpty(this.a.h)) {
                        this.a.q(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof GameRelatedForumsResMsg)) {
                    if (ListUtils.isEmpty(this.a.h)) {
                        this.a.q(false, true);
                    }
                } else {
                    GameRelatedForumsResMsg gameRelatedForumsResMsg = (GameRelatedForumsResMsg) httpResponsedMessage;
                    List<SelectForumData> selectForumDataList = gameRelatedForumsResMsg.getSelectForumDataList();
                    if (ListUtils.isEmpty(selectForumDataList)) {
                        if (ListUtils.isEmpty(this.a.h)) {
                            this.a.q(false, false);
                            return;
                        }
                        return;
                    }
                    this.a.d = gameRelatedForumsResMsg.getHasMore();
                    GameRelatedForumsView.i(this.a);
                    this.a.h.addAll(selectForumDataList);
                    this.a.b.q(this.a.h);
                    this.a.b.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRelatedForumsView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.h = new ArrayList();
        this.i = 3;
        this.j = new c(this, CmdConfigHttp.CMD_GAME_RELATED_FORUMS);
        l();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h26
    /* renamed from: o */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (ListUtils.isEmpty(this.h)) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    q(false, true);
                    return;
                } else {
                    k();
                    p(false);
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_RELATED_FORUMS);
            GameData gameData = getGameData();
            if (gameData != null) {
                httpMessage.addParam("recreation_id", gameData.gameId);
            }
            httpMessage.addParam("pn", this.e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRelatedForumsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.h = new ArrayList();
        this.i = 3;
        this.j = new c(this, CmdConfigHttp.CMD_GAME_RELATED_FORUMS);
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRelatedForumsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.h = new ArrayList();
        this.i = 3;
        this.j = new c(this, CmdConfigHttp.CMD_GAME_RELATED_FORUMS);
        l();
    }

    public static /* synthetic */ int i(GameRelatedForumsView gameRelatedForumsView) {
        int i = gameRelatedForumsView.e;
        gameRelatedForumsView.e = i + 1;
        return i;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || m()) {
            return;
        }
        if (this.f == null) {
            LoadingView loadingView = new LoadingView(getContext());
            this.f = loadingView;
            loadingView.onChangeSkinType();
        }
        this.f.attachView(this, z);
    }

    private GameData getGameData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (getContext() instanceof f26) {
                return ((f26) getContext()).d1();
            }
            return null;
        }
        return (GameData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.i) {
            return;
        }
        this.i = skinType;
        LoadingView loadingView = this.f;
        if (loadingView != null) {
            loadingView.onChangeSkinType();
        }
        om5 om5Var = this.g;
        if (om5Var != null) {
            om5Var.onChangeSkinType();
        }
        this.b.notifyDataSetChanged();
    }

    public void j() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (loadingView = this.f) != null) {
            loadingView.dettachView(this);
            this.f = null;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            om5 om5Var = this.g;
            if (om5Var != null) {
                om5Var.dettachView(this);
                this.g = null;
            }
            this.a.setVisibility(0);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LoadingView loadingView = this.f;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            om5 om5Var = this.g;
            if (om5Var != null) {
                return om5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h26
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SelectForumItemAdapter selectForumItemAdapter = this.b;
            if (selectForumItemAdapter != null) {
                selectForumItemAdapter.r(null);
            }
            MessageManager.getInstance().unRegisterListener(this.j);
            j();
        }
    }

    @Override // com.baidu.tieba.h26
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GameData gameData = getGameData();
            if (gameData != null) {
                return String.format(getContext().getString(R.string.obfuscated_res_0x7f0f08c8), gameData.gameName);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03cb, (ViewGroup) this, true);
            this.a = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f092144);
            this.b = new SelectForumItemAdapter(this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.c = linearLayoutManager;
            this.a.setLayoutManager(linearLayoutManager);
            this.a.setAdapter(this.b);
            this.a.addOnScrollListener(new a(this));
            MessageManager.getInstance().registerListener(this.j);
        }
    }

    public void q(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || n()) {
            return;
        }
        if (this.g == null) {
            this.g = new om5(getContext(), new b(this));
        }
        this.g.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.g.attachView(this, z);
        if (z2) {
            this.g.o();
        } else {
            this.g.g(R.drawable.new_pic_emotion_01);
            this.g.d();
        }
        this.g.n(getContext().getString(R.string.obfuscated_res_0x7f0f00bb));
        this.a.setVisibility(8);
    }
}
