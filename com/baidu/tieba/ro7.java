package com.baidu.tieba;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ro7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<FrsFragment> a;
    public LinearLayout b;
    public View c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public View g;
    public View h;
    public List<so7> i;
    public List<FeedForumData> j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public i9 r;

    /* loaded from: classes7.dex */
    public class d extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro7 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LikeReturnData a;
            public final /* synthetic */ d b;

            public a(d dVar, LikeReturnData likeReturnData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, likeReturnData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = likeReturnData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.b.a.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.a.getFid())) {
                            this.b.a.j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.b.a.j.size() <= 0) {
                        this.b.a.m();
                    } else {
                        this.b.a.p();
                    }
                }
            }
        }

        public d(ro7 ro7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro7Var;
        }

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.k.getErrorCode(), this.a.k.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.k.getErrorString());
                } else if (obj != null) {
                    LikeReturnData likeReturnData = (LikeReturnData) obj;
                    if (ListUtils.getCount(this.a.j) > 0 && likeReturnData != null) {
                        Iterator it = this.a.i.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            so7 so7Var = (so7) it.next();
                            FeedForumData feedForumData = (FeedForumData) so7Var.f.getTag();
                            if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(likeReturnData.getFid())) {
                                feedForumData.setIsLike(1);
                                this.a.l(so7Var);
                                break;
                            }
                        }
                        if (this.a.m == 1) {
                            this.a.l.postDelayed(new a(this, likeReturnData), 1000L);
                        }
                    }
                } else if (!StringUtils.isNull(this.a.k.getErrorString())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), this.a.k.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro7 a;

        public a(ro7 ro7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            FeedForumData feedForumData;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090c7e) {
                    if (ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && (feedForumData = (FeedForumData) view2.getTag()) != null) {
                        this.a.k.e0(feedForumData.getForumName(), feedForumData.getForumId());
                        if (this.a.m == 1) {
                            str3 = "c10028";
                        } else {
                            str3 = "c10040";
                        }
                        TiebaStatic.log(new StatisticItem(str3).param("fid", feedForumData.getForumId()));
                    }
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091519) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f090cef) {
                        FeedForumData feedForumData2 = (FeedForumData) view2.getTag();
                        if (feedForumData2 != null) {
                            if (this.a.m == 1) {
                                str = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                            } else {
                                str = "";
                            }
                            this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str)));
                            if (this.a.m == 2) {
                                str2 = "c10042";
                            } else {
                                str2 = "c10030";
                            }
                            TiebaStatic.log(new StatisticItem(str2).param("fid", feedForumData2.getForumId()));
                        }
                    } else if (view2.getId() == this.a.f.getId() && ListUtils.getCount(this.a.j) > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.a.a.getPageActivity(), (Serializable) this.a.j)));
                        TiebaStatic.log(new StatisticItem("c10046").param("fid", this.a.n));
                    }
                } else {
                    this.a.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.a.n));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro7 a;

        public b(ro7 ro7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro7Var;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                if (this.a.j != null) {
                    this.a.j.clear();
                }
                this.a.m();
                z45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ro7 ro7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
            }
        }
    }

    public ro7() {
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
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new a(this);
        this.r = new d(this);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            z45 z45Var = new z45(this.a.getPageActivity());
            z45Var.setMessage(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0eb0));
            z45Var.setPositiveButton(R.string.alert_yes_button, new b(this));
            z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new c(this));
            z45Var.create(this.a).show();
        }
    }

    public ro7(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new a(this);
        this.r = new d(this);
        n(tbPageContext, view2, i, z, bdUniqueId);
    }

    public final void l(so7 so7Var) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, so7Var) == null) && so7Var != null && (entelechyUserLikeButton = so7Var.f) != null) {
            entelechyUserLikeButton.h(true);
            so7Var.f.setEnabled(false);
        }
    }

    public final String k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0) {
                return "0";
            }
            if (i < 10000) {
                return String.valueOf(i);
            }
            if (i == 10000) {
                return "1W";
            }
            float f = i / 10000.0f;
            if (f <= 9999.9f) {
                return String.format("%.1fW", Float.valueOf(f));
            }
            return "9999.9+W";
        }
        return (String) invokeI.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setVisibility(8);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setVisibility(0);
        }
    }

    public void n(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view2, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.a = tbPageContext;
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cc0);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090cc1);
            this.g = view2.findViewById(R.id.obfuscated_res_0x7f0914a9);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09151a);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091519);
            this.e = imageView;
            imageView.setOnClickListener(this.q);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090af7);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090af6);
            this.f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.k.setLoadDataCallBack(this.r);
            this.m = i;
            this.p = z;
        }
    }

    public void o(String str, List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.n = str;
            this.j = list;
            p();
            if (this.m == 2 && !this.o) {
                TiebaStatic.log(new StatisticItem("c10035").param("fid", this.n));
                this.o = true;
            }
        }
    }

    public final void p() {
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.j) == 0) {
                m();
                return;
            }
            r();
            if (this.j.size() > 2) {
                size = 2;
            } else {
                size = this.j.size();
            }
            int size2 = size - this.i.size();
            if (size2 > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    if (this.m == 1) {
                        i = R.layout.obfuscated_res_0x7f0d0376;
                    } else {
                        i = R.layout.obfuscated_res_0x7f0d035e;
                    }
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(i, (ViewGroup) null);
                    this.b.addView(inflate);
                    this.i.add(new so7(inflate));
                }
            } else if (size2 < 0) {
                for (int i3 = 0; i3 < (-size2); i3++) {
                    int size3 = this.i.size() - 1;
                    this.b.removeView(this.i.get(size3).a);
                    this.i.remove(size3);
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                FeedForumData feedForumData = this.j.get(i4);
                so7 so7Var = this.i.get(i4);
                if (feedForumData != null && so7Var != null) {
                    so7Var.a.setTag(feedForumData);
                    so7Var.a.setOnClickListener(this.q);
                    so7Var.b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    so7Var.b.setPlaceHolder(1);
                    so7Var.b.startLoad(feedForumData.getAvatar(), 15, false);
                    so7Var.c.setText(feedForumData.getForumName());
                    so7Var.d.setText(String.format(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f02f7), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    so7Var.e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        so7Var.f.setClickable(true);
                        so7Var.f.setOnClickListener(this.q);
                        so7Var.f.setTag(feedForumData);
                        so7Var.f.h(false);
                        so7Var.f.setEnabled(true);
                    } else {
                        l(so7Var);
                    }
                }
            }
            if (this.p) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0110, 1);
            for (so7 so7Var : this.i) {
                SkinManager.setBackgroundResource(so7Var.a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(so7Var.c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(so7Var.d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(so7Var.e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = so7Var.f;
                entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
            }
        }
    }
}
