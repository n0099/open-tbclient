package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sy9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String g;
    public transient /* synthetic */ FieldHolder $fh;
    public final qu9 a;
    public final View.OnClickListener b;
    public final View.OnClickListener c;
    public View.OnClickListener d;
    public final View.OnClickListener e;
    public final TbRichTextView.y f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy9 a;

        public a(sy9 sy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            AlaInfoData alaInfoData;
            String str7;
            int i;
            String str8;
            String str9;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i2 = -1;
                if (view2 instanceof HeadImageView) {
                    HeadImageView headImageView = (HeadImageView) view2;
                    String userId = headImageView.getUserId();
                    String targetScheme = headImageView.getTargetScheme();
                    String userName = headImageView.getUserName();
                    String fid = headImageView.getFid();
                    String tid = headImageView.getTid();
                    String fName = headImageView.getFName();
                    int floor = headImageView.getFloor();
                    alaInfoData = headImageView.getAlaInfo();
                    int liveStatus = headImageView.getLiveStatus();
                    if (alaInfoData != null) {
                        str8 = userId;
                        i = liveStatus;
                        if (liveStatus == 1 || alaInfoData.live_status == 1) {
                            StatisticItem statisticItem = new StatisticItem("c13715");
                            statisticItem.param("fid", fid);
                            statisticItem.param("fname", fName);
                            AlaUserInfoData alaUserInfoData = alaInfoData.user_info;
                            str9 = targetScheme;
                            if (alaUserInfoData != null) {
                                j = alaUserInfoData.user_id;
                            } else {
                                j = 0;
                            }
                            statisticItem.param("obj_param1", j);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("tid", tid);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfoData));
                            if (alaInfoData.mYyExtData != null) {
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                                TiebaStaticHelper.addYYParam(statisticItem, alaInfoData.mYyExtData);
                            }
                            TiebaStatic.log(statisticItem);
                            TiebaStatic.log(new StatisticItem("c11923"));
                            str6 = userName;
                            str7 = tid;
                            str5 = str9;
                            str4 = str8;
                            i2 = i;
                        }
                    } else {
                        i = liveStatus;
                        str8 = userId;
                    }
                    str9 = targetScheme;
                    if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem2 = new StatisticItem("c13267");
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", fid);
                        statisticItem2.param("tid", tid);
                        statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.log(new StatisticItem("c11923"));
                    str6 = userName;
                    str7 = tid;
                    str5 = str9;
                    str4 = str8;
                    i2 = i;
                } else {
                    if (view2.getTag(R.id.tag_user_id) instanceof String) {
                        str = (String) view2.getTag(R.id.tag_user_id);
                    } else if (view2.getTag() instanceof String) {
                        str = (String) view2.getTag();
                    } else {
                        str = null;
                    }
                    if (view2.getTag(R.id.tag_user_name) instanceof String) {
                        str2 = (String) view2.getTag(R.id.tag_user_name);
                    } else {
                        str2 = null;
                    }
                    if ((view2.getTag() instanceof SparseArray) && (((SparseArray) view2.getTag()).get(R.id.tag_user_id) instanceof String)) {
                        str3 = (String) ((SparseArray) view2.getTag()).get(R.id.tag_user_id);
                    } else {
                        str3 = str;
                    }
                    if (view2.getTag(R.id.tag_user_target_scheme) instanceof String) {
                        str5 = (String) view2.getTag(R.id.tag_user_target_scheme);
                        str4 = str3;
                    } else {
                        str4 = str3;
                        str5 = "";
                    }
                    str6 = str2;
                    alaInfoData = null;
                    str7 = null;
                }
                if (view2.getTag(R.id.tag_statistic_item) instanceof StatisticItem) {
                    TiebaStatic.log((StatisticItem) view2.getTag(R.id.tag_statistic_item));
                }
                if (view2.getTag(R.id.tag_nick_name_activity) != null && (view2.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                    String str10 = (String) view2.getTag(R.id.tag_nick_name_activity);
                    if (!TextUtils.isEmpty(str10) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        BrowserHelper.startWebActivity((Context) this.a.a.getPageContext().getPageActivity(), (String) null, str10, true);
                        return;
                    }
                }
                String str11 = null;
                if (view2.getTag(R.id.tag_virtual_user_url) instanceof String) {
                    str11 = (String) view2.getTag(R.id.tag_virtual_user_url);
                }
                if (ju9.a(str5)) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str5);
                } else if (str11 != null) {
                    if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str11});
                } else if (str4 != null) {
                    if (alaInfoData != null && (i2 == 1 || alaInfoData.live_status == 1)) {
                        if (alaInfoData.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.a.a.getPageContext(), alaInfoData);
                            TbPageContext pageContext = this.a.a.getPageContext();
                            YyExtData yyExtData = alaInfoData.mYyExtData;
                            String str12 = yyExtData.mSid;
                            String str13 = yyExtData.mSsid;
                            String str14 = yyExtData.mTemplateId;
                            YYLiveUtil.jumpToYYLiveRoom(pageContext, str12, str13, str14, "" + alaInfoData.roomId, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a.getPageContext().getPageActivity(), str4, str6, this.a.a.A1(), AddFriendActivityConfig.TYPE_PB_HEAD, str7, null)));
                    }
                }
                if (this.a.a instanceof PbCommentFloatActivity) {
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", ((PbCommentFloatActivity) this.a.a).F1().getForumId());
                    statisticItem3.param("tid", ((PbCommentFloatActivity) this.a.a).F1().N1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", ((PbCommentFloatActivity) this.a.a).F1().R0());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 6);
                    statisticItem3.param("obj_locate", ((PbCommentFloatActivity) this.a.a).f2());
                    TiebaStatic.log(statisticItem3);
                }
                if ((view2.getId() == R.id.obfuscated_res_0x7f0929e5 || view2.getId() == R.id.obfuscated_res_0x7f091a1b || view2.getId() == R.id.obfuscated_res_0x7f091bf8) && (view2.getTag(R.id.tag_is_top_question) instanceof Boolean)) {
                    c1a.v(1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(sy9 sy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag(R.id.tag_user_id) instanceof String)) {
                return;
            }
            BrowserHelper.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), sy9.g + "?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy9 a;

        public c(sy9 sy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                return;
            }
            String str = null;
            if (view2.getTag() != null) {
                str = (String) view2.getTag();
            }
            if (str != null) {
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
            TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy9 a;

        public d(sy9 sy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy9Var;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, str2, str3, str4, str5, str6, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(this.a.a.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948167894, "Lcom/baidu/tieba/sy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948167894, "Lcom/baidu/tieba/sy9;");
                return;
            }
        }
        g = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    }

    public sy9(qu9 qu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.c = new b(this);
        this.d = new View.OnClickListener() { // from class: com.baidu.tieba.ry9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    sy9.c(view2);
                }
            }
        };
        this.e = new c(this);
        this.f = new d(this);
        this.a = qu9Var;
    }

    public static /* synthetic */ void c(View view2) {
        String str;
        boolean z = view2 instanceof HeadCustomImageView;
        String str2 = null;
        if ((z || (view2 instanceof VirtualImageStatusTip)) && (view2.getTag(R.id.tag_user_name) instanceof String) && (view2.getTag(R.id.tag_user_id) instanceof String)) {
            str2 = (String) view2.getTag(R.id.tag_user_id);
            str = (String) view2.getTag(R.id.tag_user_name);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (z) {
                HeadCustomImageView headCustomImageView = (HeadCustomImageView) view2;
                kx9.a(kx9.a, headCustomImageView.getTid(), headCustomImageView.getLocate(), headCustomImageView.getBubble(), headCustomImageView.getBubbleName(), headCustomImageView.getVirtualHeadUid());
            }
            if (z && ((HeadCustomImageView) view2).b()) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), str2, str)));
        }
        c1a.v(1);
    }
}
