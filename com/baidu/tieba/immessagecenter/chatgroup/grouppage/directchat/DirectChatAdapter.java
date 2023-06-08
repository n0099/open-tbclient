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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewSingleClickCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.kf8;
import com.baidu.tieba.le8;
import com.baidu.tieba.mh8;
import com.baidu.tieba.n95;
import com.baidu.tieba.nh8;
import com.baidu.tieba.o75;
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
    public le8 j;
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
            this.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908ba);
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908bb);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908b9);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908bd);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908c2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof kf8)) {
                kf8 kf8Var = (kf8) view2.getTag();
                AbilityItem a = kf8Var.a();
                this.a.x(a);
                String str = "";
                if (a.getStyleConf() != null && a.getStyleConf().getContent() != null) {
                    str = a.getStyleConf().getContent();
                }
                String str2 = str;
                if ("call_robot".equals(a.getType())) {
                    int i = 0;
                    View view3 = null;
                    if (kf8Var.b() != null) {
                        i = kf8Var.b().intValue();
                    }
                    if (kf8Var.c() != null) {
                        view3 = kf8Var.c();
                    }
                    String obj = a.getConfMap().get("skill_id").toString();
                    if (view3 != null) {
                        this.a.r(obj, view3, i);
                    }
                }
                nh8.g("c15187", str2, this.a.c, this.a.s(a), this.a.t(a), this.a.d, this.a.e);
            }
        }
    }

    public DirectChatAdapter(Context context, @NonNull le8 le8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, le8Var};
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
        this.j = le8Var;
        this.h = context.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.M_W_X004);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: B */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
            return new ViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d026a, viewGroup, false));
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.d = j;
        }
    }

    public final void D(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewHolder) == null) {
            viewHolder.d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i = this.i;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 16;
            viewHolder.c.setLayoutParams(layoutParams);
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.c = j;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    public final void I(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder) == null) {
            viewHolder.c.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i = this.i;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 16;
            viewHolder.d.setLayoutParams(layoutParams);
        }
    }

    public void J(@NonNull List<AbilityItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.b = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: A */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AbilityItem abilityItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, viewHolder, i) == null) && (abilityItem = (AbilityItem) ListUtils.getItem(this.b, i)) != null && abilityItem.getStyleConf() != null) {
            AbilityItem.StyleConf styleConf = abilityItem.getStyleConf();
            z(styleConf, viewHolder);
            if (!TextUtils.isEmpty(styleConf.getContent())) {
                viewHolder.d.setVisibility(0);
                viewHolder.d.setText(styleConf.getContent());
            } else {
                D(viewHolder);
            }
            viewHolder.e.setVisibility(8);
            if ("call_robot".equals(abilityItem.getType())) {
                y(abilityItem.getConfMap().get("skill_id").toString(), viewHolder.e);
            }
            String content = styleConf.getContent();
            if (!TextUtils.isEmpty(content) && !this.f.contains(content)) {
                nh8.g("c15186", content, this.c, s(abilityItem), t(abilityItem), this.d, this.e);
                this.f.add(content);
            }
            viewHolder.b.setTag(new kf8(abilityItem, Integer.valueOf(i), viewHolder.e));
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

    public final void G(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) {
            o75 d = o75.d(viewHolder.b);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0208);
            o75 d2 = o75.d(viewHolder.d);
            d2.B(R.dimen.T_X08);
            d2.C(R.string.F_X02);
            d2.w(R.color.CAM_X0105);
        }
    }

    public final String s(AbilityItem abilityItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, abilityItem)) == null) {
            if (abilityItem != null && abilityItem.getConfMap() != null && abilityItem.getConfMap().get("bot_uk") != null) {
                return BIMManager.getBdUidFromBdUK(abilityItem.getConfMap().get("bot_uk").toString());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void H(@NonNull ViewHolder viewHolder, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, viewHolder, str, str2) == null) {
            o75 d = o75.d(viewHolder.b);
            d.o(R.string.J_X01);
            d.g(str);
            o75 d2 = o75.d(viewHolder.d);
            d2.B(R.dimen.T_X08);
            d2.C(R.string.F_X02);
            viewHolder.d.setTextColor(Color.parseColor(str2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public final void r(@NonNull String str, @NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, str, view2, i) == null) {
            n95 m = n95.m();
            m.w("sp_key_direct_show_red" + str, true);
            view2.setVisibility(8);
            notifyItemChanged(i);
        }
    }

    public final String t(AbilityItem abilityItem) {
        InterceptResult invokeL;
        String str;
        GroupChatFragment t1;
        BotsDTO B0;
        BotsDTO.BotListDTO findBotByUk;
        BotsDTO.BotListDTO.SkillDTO cloneSkillById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, abilityItem)) == null) {
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
            if (!(context instanceof GroupChatActivity) || (t1 = ((GroupChatActivity) context).t1()) == null || t1.g2() == null || (B0 = t1.g2().B0()) == null || (findBotByUk = B0.findBotByUk(str)) == null || (cloneSkillById = findBotByUk.cloneSkillById(i)) == null) {
                return "";
            }
            return cloneSkillById.getName();
        }
        return (String) invokeL.objValue;
    }

    public final Uri u(@NonNull AbilityItem.StyleConf styleConf, @NonNull ViewHolder viewHolder) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, styleConf, viewHolder)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (styleConf.getDay() == null || styleConf.getDay().getContentColor() == null || styleConf.getDay().getBackgroundColor() == null || styleConf.getDark() == null || styleConf.getDark().getContentColor() == null || styleConf.getDark().getBackgroundColor() == null) {
                G(viewHolder);
            }
            if (skinType == 4) {
                if (styleConf.getDark() != null && !TextUtils.isEmpty(styleConf.getDark().getIcon())) {
                    str = styleConf.getDark().getIcon();
                } else {
                    str = null;
                }
                if (styleConf.getDark() != null && !TextUtils.isEmpty(styleConf.getDark().getBackgroundColor()) && !TextUtils.isEmpty(styleConf.getDark().getContentColor())) {
                    H(viewHolder, styleConf.getDark().getBackgroundColor(), styleConf.getDark().getContentColor());
                }
            } else {
                if (styleConf.getDay() != null && !TextUtils.isEmpty(styleConf.getDay().getIcon())) {
                    str = styleConf.getDay().getIcon();
                } else {
                    str = null;
                }
                if (styleConf.getDay() != null && !TextUtils.isEmpty(styleConf.getDay().getBackgroundColor()) && !TextUtils.isEmpty(styleConf.getDay().getContentColor())) {
                    H(viewHolder, styleConf.getDay().getBackgroundColor(), styleConf.getDay().getContentColor());
                }
            }
            if (StringUtils.isNull(str)) {
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeLL.objValue;
    }

    public final void x(@NonNull AbilityItem abilityItem) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, abilityItem) == null) {
            Map<String, Object> confMap = abilityItem.getConfMap();
            if (confMap != null && confMap.containsKey(BigdayActivityConfig.JUMP_URL) && (confMap.get(BigdayActivityConfig.JUMP_URL) instanceof String)) {
                str = (String) confMap.get(BigdayActivityConfig.JUMP_URL);
            } else {
                str = "";
            }
            if (!StringUtils.isNull(str) && str.contains("vmagic-mobile#/identity")) {
                Context context = this.a;
                if (context instanceof TbPageContextSupport) {
                    mh8.a(((TbPageContextSupport) context).getPageContext(), str, 2);
                    return;
                }
            }
            this.j.d(abilityItem, null, GroupInputViewController.SourceType.DIRECT_CHAT);
        }
    }

    public final void y(@NonNull String str, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, view2) == null) {
            n95 m = n95.m();
            if (!m.i("sp_key_direct_show_red" + str, false)) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void z(@NonNull AbilityItem.StyleConf styleConf, @NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, styleConf, viewHolder) == null) {
            Uri u = u(styleConf, viewHolder);
            if (u == null) {
                I(viewHolder);
                return;
            }
            viewHolder.c.setVisibility(0);
            Glide.with(viewHolder.c.getContext()).load(u).placeholder((int) R.drawable.pic_use_header_40_n).into(viewHolder.c);
        }
    }
}
