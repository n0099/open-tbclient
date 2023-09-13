package com.baidu.tieba.immessagecenter.chatgroup.grouppage.directchat;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewSingleClickCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.as8;
import com.baidu.tieba.gp8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.io8;
import com.baidu.tieba.zr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class DirectChatAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<AbilityItem> b;
    public long c;
    public long d;
    public String e;
    public final List<String> f;
    public final int g;
    public final int h;
    public final int i;
    @NonNull
    public io8 j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;
        public LinearLayout b;
        public ImageView c;
        public TextView d;
        public RelativeLayout e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NonNull DirectChatAdapter directChatAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {directChatAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908ca);
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908cb);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908c9);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908cd);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908d2);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DirectChatAdapter a;

        public a(DirectChatAdapter directChatAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {directChatAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = directChatAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof gp8)) {
                gp8 gp8Var = (gp8) view2.getTag();
                AbilityItem a = gp8Var.a();
                this.a.y(a);
                String str = "";
                if (a.getStyleConf() != null && a.getStyleConf().getContent() != null) {
                    str = a.getStyleConf().getContent();
                }
                String str2 = str;
                if ("call_robot".equals(a.getType())) {
                    int i = 0;
                    View view3 = null;
                    if (gp8Var.b() != null) {
                        i = gp8Var.b().intValue();
                    }
                    if (gp8Var.c() != null) {
                        view3 = gp8Var.c();
                    }
                    String obj = a.getConfMap().get("skill_id").toString();
                    if (view3 != null) {
                        this.a.s(obj, view3, i);
                    }
                }
                as8.j("c15187", str2, this.a.c, this.a.t(a), this.a.u(a), this.a.d, this.a.e);
            }
        }
    }

    public DirectChatAdapter(Context context, @NonNull io8 io8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, io8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.k = new a(this);
        this.a = context;
        this.j = io8Var;
        this.h = context.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.M_W_X004);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: C */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            return new ViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0276, viewGroup, false));
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.d = j;
        }
    }

    public final void E(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewHolder) == null) {
            viewHolder.d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i = this.i;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 16;
            viewHolder.c.setLayoutParams(layoutParams);
        }
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.c = j;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public final void J(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewHolder) == null) {
            viewHolder.c.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i = this.i;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 16;
            viewHolder.d.setLayoutParams(layoutParams);
        }
    }

    public void K(@NonNull List<AbilityItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.b = list;
        }
    }

    public void A(@NonNull AbilityItem.StyleConf styleConf, @NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, styleConf, viewHolder) == null) {
            Uri x = x(styleConf, viewHolder);
            if (x == null) {
                J(viewHolder);
                return;
            }
            viewHolder.c.setVisibility(0);
            Glide.with(viewHolder.c.getContext()).load(x).placeholder((int) R.drawable.pic_use_header_40_n).into(viewHolder.c);
        }
    }

    public final void z(@NonNull String str, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, view2) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            if (!sharedPrefHelper.getBoolean("sp_key_direct_show_red" + str, false)) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AbilityItem abilityItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i) == null) && (abilityItem = (AbilityItem) ListUtils.getItem(this.b, i)) != null && abilityItem.getStyleConf() != null) {
            AbilityItem.StyleConf styleConf = abilityItem.getStyleConf();
            A(styleConf, viewHolder);
            if (!TextUtils.isEmpty(styleConf.getContent())) {
                viewHolder.d.setVisibility(0);
                viewHolder.d.setText(styleConf.getContent());
            } else {
                E(viewHolder);
            }
            viewHolder.e.setVisibility(8);
            if ("call_robot".equals(abilityItem.getType())) {
                z(abilityItem.getConfMap().get("skill_id").toString(), viewHolder.e);
            }
            String content = styleConf.getContent();
            if (!TextUtils.isEmpty(content) && !this.f.contains(content)) {
                as8.j("c15186", content, this.c, t(abilityItem), u(abilityItem), this.d, this.e);
                this.f.add(content);
            }
            viewHolder.b.setTag(new gp8(abilityItem, Integer.valueOf(i), viewHolder.e));
            ViewSingleClickCompat.setOnClickListener(viewHolder.b, this.k);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.a.getLayoutParams();
            if (i == 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.h;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.g;
            }
            viewHolder.a.setLayoutParams(layoutParams);
        }
    }

    public final void H(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewHolder) == null) {
            EMManager.from(viewHolder.b).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0208);
            EMManager.from(viewHolder.d).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
        }
    }

    public final String t(AbilityItem abilityItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, abilityItem)) == null) {
            if (abilityItem != null && abilityItem.getConfMap() != null && abilityItem.getConfMap().get("bot_uk") != null) {
                return BIMManager.getBdUidFromBdUK(abilityItem.getConfMap().get("bot_uk").toString());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void I(@NonNull ViewHolder viewHolder, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder, str, str2) == null) {
            EMManager.from(viewHolder.b).setCorner(R.string.J_X01).setBackGroundColorString(str);
            EMManager.from(viewHolder.d).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02);
            viewHolder.d.setTextColor(Color.parseColor(str2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public final void s(@NonNull String str, @NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, str, view2, i) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putBoolean("sp_key_direct_show_red" + str, true);
            view2.setVisibility(8);
            notifyItemChanged(i);
        }
    }

    public final String u(AbilityItem abilityItem) {
        InterceptResult invokeL;
        String str;
        GroupChatFragment t1;
        BotsDTO F0;
        BotsDTO.BotListDTO findBotByUk;
        BotsDTO.BotListDTO.SkillDTO cloneSkillById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, abilityItem)) == null) {
            if (abilityItem == null || abilityItem.getConfMap() == null || abilityItem.getConfMap().get("bot_uk") == null) {
                str = "";
            } else {
                str = abilityItem.getConfMap().get("bot_uk").toString();
            }
            int i = 0;
            if (abilityItem != null && abilityItem.getConfMap() != null && abilityItem.getConfMap().get("skill_id") != null) {
                try {
                    i = Integer.parseInt(abilityItem.getConfMap().get("skill_id").toString());
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            Context context = this.a;
            if (!(context instanceof GroupChatActivity) || (t1 = ((GroupChatActivity) context).t1()) == null || t1.w2() == null || (F0 = t1.w2().F0()) == null || (findBotByUk = F0.findBotByUk(str)) == null || (cloneSkillById = findBotByUk.cloneSkillById(i)) == null) {
                return "";
            }
            return cloneSkillById.getName();
        }
        return (String) invokeL.objValue;
    }

    public final Uri x(@NonNull AbilityItem.StyleConf styleConf, @NonNull ViewHolder viewHolder) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, styleConf, viewHolder)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (styleConf.getDay() == null || styleConf.getDay().getContentColor() == null || styleConf.getDay().getBackgroundColor() == null || styleConf.getDark() == null || styleConf.getDark().getContentColor() == null || styleConf.getDark().getBackgroundColor() == null) {
                H(viewHolder);
            }
            if (skinType == 4) {
                if (styleConf.getDark() != null && !TextUtils.isEmpty(styleConf.getDark().getIcon())) {
                    str = styleConf.getDark().getIcon();
                } else {
                    str = null;
                }
                if (styleConf.getDark() != null && !TextUtils.isEmpty(styleConf.getDark().getBackgroundColor()) && !TextUtils.isEmpty(styleConf.getDark().getContentColor())) {
                    I(viewHolder, styleConf.getDark().getBackgroundColor(), styleConf.getDark().getContentColor());
                }
            } else {
                if (styleConf.getDay() != null && !TextUtils.isEmpty(styleConf.getDay().getIcon())) {
                    str = styleConf.getDay().getIcon();
                } else {
                    str = null;
                }
                if (styleConf.getDay() != null && !TextUtils.isEmpty(styleConf.getDay().getBackgroundColor()) && !TextUtils.isEmpty(styleConf.getDay().getContentColor())) {
                    I(viewHolder, styleConf.getDay().getBackgroundColor(), styleConf.getDay().getContentColor());
                }
            }
            if (StringUtils.isNull(str)) {
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeLL.objValue;
    }

    public final void y(@NonNull AbilityItem abilityItem) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, abilityItem) == null) {
            Map<String, Object> confMap = abilityItem.getConfMap();
            if (confMap != null && confMap.containsKey(BigdayActivityConfig.JUMP_URL) && (confMap.get(BigdayActivityConfig.JUMP_URL) instanceof String)) {
                str = (String) confMap.get(BigdayActivityConfig.JUMP_URL);
            } else {
                str = "";
            }
            if (!StringUtils.isNull(str) && str.contains("vmagic-mobile#/identity")) {
                Context context = this.a;
                if (context instanceof TbPageContextSupport) {
                    zr8.a(((TbPageContextSupport) context).getPageContext(), str, 2);
                    return;
                }
            }
            this.j.d(abilityItem, null, GroupInputViewController.SourceType.DIRECT_CHAT);
        }
    }
}
