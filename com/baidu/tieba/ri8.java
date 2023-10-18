package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.im.under.common.uiliststyle.group.emjio.custom.SwitcherTextView;
import com.baidu.tieba.im.under.common.uiliststyle.group.emjio.view.EmojiReplyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ri8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<EmojiData> a;
    @Nullable
    public ea8 b;
    @Nullable
    public BaseItem<? extends TbBaseMsg> c;
    @NonNull
    public final EmojiReplyView d;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiData a;
        public final /* synthetic */ ri8 b;

        public a(ri8 ri8Var, EmojiData emojiData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri8Var, emojiData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ri8Var;
            this.a = emojiData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b != null && this.b.c != null) {
                yi8.f(this.b.b, this.a, this.b.c, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ri8 b;

        public b(ri8 ri8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ri8Var;
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(CriusAttrConstants.POSITION, Integer.valueOf(this.a));
                AbilityItem abilityItem = new AbilityItem("open_emoji_detail", hashMap, null);
                if (this.b.b != null) {
                    this.b.b.d(abilityItem, this.b.c, null);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiData a;
        public final /* synthetic */ ri8 b;

        public c(ri8 ri8Var, EmojiData emojiData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri8Var, emojiData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ri8Var;
            this.a = emojiData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b != null && this.b.c != null) {
                List<EmojiData> emojiList = this.b.c.getTbMsg().getEmojiList();
                if (emojiList != null && emojiList.size() > 10) {
                    yi8.f(this.b.b, this.a, this.b.c, 2);
                } else {
                    yi8.e(this.b.b, 2, this.b.c);
                }
            }
        }
    }

    public ri8(@NonNull EmojiReplyView emojiReplyView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emojiReplyView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.d = emojiReplyView;
    }

    public void c(@NonNull ea8 ea8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ea8Var) == null) {
            this.b = ea8Var;
        }
    }

    public void d(@NonNull BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseItem) == null) {
            this.c = baseItem;
        }
    }

    public EmojiData i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.a.get(i);
        }
        return (EmojiData) invokeI.objValue;
    }

    public final void l(@NonNull List<EmojiData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            j();
            for (EmojiData emojiData : list) {
                if (emojiData != null) {
                    this.a.add(emojiData.shallowClone());
                }
            }
        }
    }

    public final Map<String, Integer> e(@NonNull List<EmojiData> list, @NonNull List<EmojiData> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            HashMap hashMap = new HashMap();
            if (list.size() < list2.size()) {
                hashMap.put("emoji_operation_add", Integer.valueOf(list.size() - 1));
            } else {
                int i = 0;
                if (list.size() <= list2.size()) {
                    while (true) {
                        if (i >= list2.size()) {
                            break;
                        }
                        EmojiData emojiData = list.get(i);
                        EmojiData emojiData2 = list2.get(i);
                        if (emojiData.getContent().equals(emojiData2.getContent())) {
                            if (emojiData.getAllNum() > emojiData2.getAllNum()) {
                                hashMap.put("emoji_operation_update_reduce", Integer.valueOf(i));
                                break;
                            } else if (emojiData.getAllNum() < emojiData2.getAllNum()) {
                                hashMap.put("emoji_operation_update_add", Integer.valueOf(i));
                                break;
                            }
                        }
                        i++;
                    }
                } else {
                    while (true) {
                        if (i < list2.size()) {
                            if (!list.get(i).getContent().equals(list2.get(i).getContent())) {
                                break;
                            }
                            i++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        hashMap.put("emoji_operation_remove", Integer.valueOf(i));
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public View f(@NonNull ViewGroup viewGroup, View view2, int i, @NonNull EmojiData emojiData) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048579, this, viewGroup, view2, i, emojiData)) == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0520, viewGroup, false);
            inflate.setOnClickListener(new c(this, emojiData));
            ((TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909b1)).setVisibility(8);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090127);
            imageView.setVisibility(0);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            inflate.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0800e3, R.color.CAM_X0108, null);
            EMManager.from(inflate).setCorner(R.string.J_X04).setAlpha(R.string.A_X06).setBackGroundColor(R.color.CAM_X0623);
            return inflate;
        }
        return (View) invokeLLIL.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.clear();
        }
    }

    public View h(@NonNull ViewGroup viewGroup, View view2, int i, @NonNull EmojiData emojiData, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{viewGroup, view2, Integer.valueOf(i), emojiData, Integer.valueOf(i2)})) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0520, viewGroup, false);
            }
            view2.setOnClickListener(new a(this, emojiData));
            view2.setOnLongClickListener(new b(this, i));
            ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090127)).setVisibility(8);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f091696);
            tBLottieAnimationView.loop(false);
            tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f11000e);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909b1);
            tbImageView.setVisibility(0);
            if (i2 == 1) {
                tBLottieAnimationView.setVisibility(0);
                tBLottieAnimationView.playAnimation();
                tbImageView.setAnimation(AnimationUtils.loadAnimation(viewGroup.getContext(), R.anim.obfuscated_res_0x7f01013a));
            } else {
                tBLottieAnimationView.setVisibility(8);
                tbImageView.clearAnimation();
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(dimenPixelSize, 0, 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.startLoad(emojiData.getContent());
            SwitcherTextView switcherTextView = (SwitcherTextView) view2.findViewById(R.id.obfuscated_res_0x7f0909b2);
            switcherTextView.setVisibility(0);
            if (i2 == 1) {
                switcherTextView.setAddAnimation();
            } else if (i2 == 2) {
                switcherTextView.setReduceAnimation();
            } else {
                switcherTextView.clearAnimation();
            }
            switcherTextView.setText(String.valueOf(emojiData.getAllNum()));
            if (emojiData.hasReplied()) {
                switcherTextView.a(true);
                EMManager.from(view2).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0302).setBorderAlpha(R.string.A_X11).setBackGroundColor(R.color.CAM_X0905);
            } else {
                switcherTextView.a(false);
                EMManager.from(view2).setCorner(R.string.J_X04).setAlpha(R.string.A_X06).setBackGroundColor(R.color.CAM_X0623);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void k(boolean z, @NonNull List<EmojiData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, list) != null) || list.isEmpty()) {
            return;
        }
        if (z && !this.a.isEmpty()) {
            Map<String, Integer> e = e(this.a, list);
            l(list);
            if (!e.isEmpty()) {
                for (Map.Entry<String, Integer> entry : e.entrySet()) {
                    String key = entry.getKey();
                    char c2 = 65535;
                    switch (key.hashCode()) {
                        case -399519344:
                            if (key.equals("emoji_operation_add")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -238402251:
                            if (key.equals("emoji_operation_remove")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1391931339:
                            if (key.equals("emoji_operation_update_reduce")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 2031673436:
                            if (key.equals("emoji_operation_update_add")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                if (c2 == 3) {
                                    this.d.f(2, entry.getValue().intValue());
                                }
                            } else {
                                this.d.f(1, entry.getValue().intValue());
                            }
                        } else {
                            this.d.i(entry.getValue().intValue());
                        }
                    } else {
                        this.d.a(entry.getValue().intValue());
                    }
                }
                return;
            }
            return;
        }
        l(list);
        this.d.e();
    }
}
