package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class m6a extends ci<nwa, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public aw9 b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public m1a g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public View.OnClickListener m;
    public CustomMessageListener n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6a a;

        public a(m6a m6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            long j;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092a1b) {
                    if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        return;
                    }
                    if (view2.getTag() != null) {
                        str4 = (String) view2.getTag();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null) {
                        UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str4});
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092a16) {
                    if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                        return;
                    }
                    BrowserHelper.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092a09) {
                    HeadImageView headView = ((HeadPendantClickableView) view2).getHeadView();
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    String fName = headView.getFName();
                    int floor = headView.getFloor();
                    AlaInfoData alaInfo = headView.getAlaInfo();
                    int liveStatus = headView.getLiveStatus();
                    if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                        if (alaInfo.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.a.a.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                        StatisticItem statisticItem = new StatisticItem("c13715");
                        statisticItem.param("fid", fid);
                        statisticItem.param("fname", fName);
                        AlaUserInfoData alaUserInfoData = alaInfo.user_info;
                        if (alaUserInfoData != null) {
                            j = alaUserInfoData.user_id;
                        } else {
                            j = 0;
                        }
                        statisticItem.param("obj_param1", j);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", tid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfo));
                        if (alaInfo.mYyExtData != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                            TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    StatisticItem statisticItem2 = new StatisticItem("c13267");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", fid);
                    statisticItem2.param("tid", tid);
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092a15) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    if (view2.getTag(R.id.tag_user_id) instanceof String) {
                        str = (String) view2.getTag(R.id.tag_user_id);
                    } else {
                        str = null;
                    }
                    if (view2.getTag(R.id.tag_user_name) instanceof String) {
                        str2 = (String) view2.getTag(R.id.tag_user_name);
                    } else {
                        str2 = null;
                    }
                    if (this.a.b != null && this.a.b.n() != null) {
                        str3 = this.a.b.n().getName();
                    } else {
                        str3 = null;
                    }
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.b != null) {
                        statisticItem3.param("fid", this.a.b.o());
                        statisticItem3.param("tid", this.a.b.T());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092a04 && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.b.o());
                    statisticItem4.param("tid", this.a.b.T());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.b.l().U());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.a).p4());
                    TiebaStatic.log(statisticItem4);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0929e7) {
                    if (this.a.mContext == null) {
                        return;
                    }
                    BrowserHelper.startWebActivity(this.a.mContext, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092a11 && this.a.mContext != null && this.a.b != null && this.a.b.R() != null && this.a.b.R().getAuthor() != null && StringUtils.isNotNull(this.a.b.R().getAuthor().getPortrait())) {
                    av5.d(this.a.b.o(), this.a.b.R().getAuthor().getPortrait(), "2", this.a.mContext);
                    bv5.c("c15281", this.a.b.o(), "2");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m6a m6aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6aVar, Integer.valueOf(i)};
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
            this.a = m6aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).q != null) {
                ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).q.setTextSize(TbConfig.getContentSize());
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m6a(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = new a(this);
        b bVar = new b(this, 2004018);
        this.n = bVar;
        this.a = baseFragment;
        baseFragment.registerListener(bVar);
    }

    public final void H(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, nwa nwaVar) {
        aw9 aw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, nwaVar) == null) && (aw9Var = this.b) != null && aw9Var.R() != null && nwaVar != null) {
            videoTabPbFloatUserInfoViewHolder.s(this.b.R().getRichTitle(), this.b.R().getTitle(), this.b.R(), K(nwaVar), this.b.z0());
            videoTabPbFloatUserInfoViewHolder.r(this.mContext, nwaVar);
        }
    }

    public final void U(TbImageView tbImageView, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, tbImageView, nwaVar) == null) && tbImageView != null && nwaVar != null && TbSingleton.getInstance().isUserGrowthOpen() && nwaVar.u().getUserGrowthData() != null) {
            int a2 = nwaVar.u().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                tbImageView.setImageResource(ss.b(a2));
                tbImageView.setVisibility(0);
                return;
            }
            tbImageView.setVisibility(8);
        }
    }

    public final void W(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && videoTabPbFloatUserInfoViewHolder != null && metaData != null && this.b != null) {
            String ipAddress = metaData.getIpAddress();
            if (!TextUtils.isEmpty(ipAddress)) {
                TextView textView = videoTabPbFloatUserInfoViewHolder.u;
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + ipAddress);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.u.setVisibility(8);
        }
    }

    public final void Z(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && this.b != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoTabPbFloatUserInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final boolean K(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nwaVar)) == null) {
            if (nwaVar != null && ListUtils.getCount(nwaVar.t0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void Q(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aw9Var) == null) {
            this.b = aw9Var;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
        }
    }

    public final void G(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, nwa nwaVar) {
        aw9 aw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, videoTabPbFloatUserInfoViewHolder, nwaVar) == null) && (aw9Var = this.b) != null && aw9Var.R() != null && this.b.R().getAuthor() != null && nwaVar != null) {
            V(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor(), nwaVar);
            a0(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor());
            Y(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor());
            k2a.x(videoTabPbFloatUserInfoViewHolder.i, nwaVar, this.b, this.l);
            U(videoTabPbFloatUserInfoViewHolder.j, nwaVar);
            T(videoTabPbFloatUserInfoViewHolder, nwaVar);
            Z(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor());
            R(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor());
            X(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor(), nwaVar);
            W(videoTabPbFloatUserInfoViewHolder, this.b.R().getAuthor());
            videoTabPbFloatUserInfoViewHolder.d(this.b.R().getAuthor());
        }
    }

    public final void a0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.h = true;
            videoTabPbFloatUserInfoViewHolder.g.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.h = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams2.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.g.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public final void I(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, nwaVar) == null) {
            videoTabPbFloatUserInfoViewHolder.q(8, null);
            aw9 aw9Var = this.b;
            if (aw9Var != null && aw9Var.R() != null && nwaVar != null) {
                if (nwaVar.f1129T) {
                    videoTabPbFloatUserInfoViewHolder.q(0, nwaVar.U());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).Q5(nwaVar.f1129T);
                }
            }
        }
    }

    public final void Y(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.h.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.h.setTag(R.id.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.h.setTag(R.id.tag_user_name, metaData.getName_show());
        this.i = metaData.isBigV();
        this.j = metaData.isNewGod();
    }

    public final int J(aw9 aw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aw9Var)) == null) {
            if (aw9Var == null || aw9Var.R() == null) {
                return 0;
            }
            if (aw9Var.R().isMutiForumThread()) {
                if (ListUtils.isEmpty(aw9Var.r()) && (aw9Var.j() == null || StringUtils.isNull(aw9Var.j().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void S(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        aw9 aw9Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, videoTabPbFloatUserInfoViewHolder) != null) || (aw9Var = this.b) == null) {
            return;
        }
        this.d = aw9Var.j;
        if (aw9Var.R() != null) {
            boolean z2 = false;
            if (this.b.R().getIs_good() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            if (this.b.R().getIs_top() == 1) {
                z2 = true;
            }
            this.e = z2;
        }
        videoTabPbFloatUserInfoViewHolder.l(this.d, this.f, this.e);
    }

    public void L(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, videoTabPbFloatUserInfoViewHolder) != null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.k(this.c);
        if (!this.h && !this.i && !this.j) {
            z = false;
        } else {
            z = true;
        }
        videoTabPbFloatUserInfoViewHolder.n(z);
        videoTabPbFloatUserInfoViewHolder.l(this.d, this.f, this.e);
        videoTabPbFloatUserInfoViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: M */
    public VideoTabPbFloatUserInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07de, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, absVideoPbFragment);
            videoTabPbFloatUserInfoViewHolder.p(this.m);
            L(videoTabPbFloatUserInfoViewHolder);
            this.viewholder = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View N(int i, View view2, ViewGroup viewGroup, nwa nwaVar, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nwaVar, videoTabPbFloatUserInfoViewHolder})) == null) {
            aw9 aw9Var = this.b;
            if (aw9Var != null && aw9Var.R() != null && nwaVar != null) {
                c6a.d(this.a.getUniqueId(), this.b, nwaVar, 1, 1);
                S(videoTabPbFloatUserInfoViewHolder);
                G(videoTabPbFloatUserInfoViewHolder, nwaVar);
                H(videoTabPbFloatUserInfoViewHolder, nwaVar);
                I(videoTabPbFloatUserInfoViewHolder, nwaVar);
                L(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.s.setVisibility(8);
                if (this.k) {
                    videoTabPbFloatUserInfoViewHolder.t.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = videoTabPbFloatUserInfoViewHolder.t.getLayoutParams();
                    layoutParams.height = view2.getHeight();
                    videoTabPbFloatUserInfoViewHolder.t.setLayoutParams(layoutParams);
                    videoTabPbFloatUserInfoViewHolder.t.bringToFront();
                } else {
                    videoTabPbFloatUserInfoViewHolder.t.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void O(nwa nwaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nwaVar) == null) && nwaVar != null && nwaVar.u() != null) {
            String userId = nwaVar.u().getUserId();
            aw9 aw9Var = this.b;
            String str2 = "";
            if (aw9Var == null) {
                str = "";
            } else {
                str = aw9Var.o();
            }
            aw9 aw9Var2 = this.b;
            if (aw9Var2 != null) {
                str2 = aw9Var2.p();
            }
            int L = nwaVar.L();
            String U = nwaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (nwaVar.u().getAlaInfo() != null) {
                AlaInfoData alaInfo = nwaVar.u().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void R(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.b != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.n;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
                layoutParams.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.m.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.m.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
            layoutParams2.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
        }
    }

    public final void T(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, nwa nwaVar) {
        aw9 aw9Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, videoTabPbFloatUserInfoViewHolder, nwaVar) == null) && (aw9Var = this.b) != null && aw9Var.R() != null) {
            this.c = 0;
            if (!this.b.R().isMutiForumThread()) {
                if (nwaVar != null && nwaVar.u() != null) {
                    this.c = nwaVar.u().getLevel_id();
                    str = nwaVar.u().getLevelName();
                } else {
                    str = "";
                }
                if (!this.b.a()) {
                    videoTabPbFloatUserInfoViewHolder.k.setVisibility(0);
                    videoTabPbFloatUserInfoViewHolder.k.setLevel(this.c, str);
                    return;
                }
                videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void V(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, nwa nwaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, videoTabPbFloatUserInfoViewHolder, metaData, nwaVar) == null) && this.b != null && metaData != null && nwaVar != null) {
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserId(metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserName(metaData.getUserName());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setTid(nwaVar.U());
            aw9 aw9Var = this.b;
            String str2 = "";
            if (aw9Var == null) {
                str = "";
            } else {
                str = aw9Var.o();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFid(str);
            aw9 aw9Var2 = this.b;
            if (aw9Var2 != null) {
                str2 = aw9Var2.p();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFName(str2);
            videoTabPbFloatUserInfoViewHolder.e.i(metaData);
            videoTabPbFloatUserInfoViewHolder.e.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoTabPbFloatUserInfoViewHolder.g(true);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(1);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(nwaVar.u().getAlaInfo());
                O(nwaVar);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.g(false);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(0);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(null);
        }
    }

    public final void X(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, nwa nwaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, nwaVar) == null) && this.b != null && nwaVar != null && nwaVar.u() != null) {
            aw9 aw9Var = this.b;
            if (aw9Var == null) {
                str = "";
            } else {
                str = aw9Var.T();
            }
            int J = J(this.b);
            int i = 4;
            if (this.b.R() != null && this.b.R().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.g == null) {
                m1a m1aVar = new m1a(this.a.getPageContext(), videoTabPbFloatUserInfoViewHolder.o, i);
                this.g = m1aVar;
                m1aVar.j(this.a.getUniqueId());
            }
            nwaVar.u().setIsLike(nwaVar.u().hadConcerned());
            this.g.l(nwaVar.u());
            this.g.y(str);
            this.g.u(this.b.R());
            m1a m1aVar2 = this.g;
            m1aVar2.p = true;
            m1aVar2.x(J);
            this.g.i(true);
            if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            }
            if (this.b.i) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            }
            if (nwaVar.u().getIsLike()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nwa nwaVar, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        N(i, view2, viewGroup, nwaVar, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }
}
