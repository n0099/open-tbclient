package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lm7 extends tm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener h;
    public final g4 i;
    public final g4 j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lm7 lm7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm7Var, Integer.valueOf(i)};
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
            this.a = lm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData)) {
                this.a.b((LikeReturnData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(lm7 lm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Boolean)) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm7 a;

        public c(lm7 lm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm7Var;
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                } else {
                    z = false;
                }
                if (!z) {
                    this.a.b.refresh();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm7(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2001266);
        this.i = new b(this);
        this.j = new c(this);
        frsFragment.registerListener(this.h);
    }

    public final void b(LikeReturnData likeReturnData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, likeReturnData) != null) || likeReturnData == null) {
            return;
        }
        FrsViewData s1 = this.b.s1();
        if (this.e != null && this.d != null && this.a != null && s1 != null && s1.getForum() != null && likeReturnData.getFid() != null) {
            if (likeReturnData.isLike() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (likeReturnData.getFid().equals(s1.getForum().getId())) {
                s1.getForum().setLike(likeReturnData.isLike());
                if (!StringUtils.isNULL(likeReturnData.getLevelName())) {
                    s1.getForum().setLevelName(likeReturnData.getLevelName());
                }
                if (likeReturnData.getUserLevel() >= 0) {
                    s1.getForum().setUser_level(likeReturnData.getUserLevel());
                }
                if (z) {
                    this.d.A0(s1, false);
                    TbadkCoreApplication.getInst().addLikeForum(this.b.v());
                    return;
                }
                wca.i().n(this.b.v(), false);
                s1.getForum().setLike(0);
                this.d.D0();
                TbadkCoreApplication.getInst().delLikeForum(this.b.v());
                return;
            }
            if (likeReturnData.isLike() == 1) {
                s1.deleteLikeFeedForum(likeReturnData.getFid());
                this.d.n0(s1);
                this.c.d(s1, this.e.i0());
            }
            if (s1.getForum().getBannerListData() != null) {
                s1.getForum().getBannerListData().setFeedForumLiked(likeReturnData.getFid(), likeReturnData.isLike());
            }
            this.a.R0();
        }
    }
}
