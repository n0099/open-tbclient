package com.baidu.tieba.im.under.common.tag.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ea8;
import com.baidu.tieba.gi8;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.v98;
import com.baidu.tieba.yi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class EmojiReplyPendantVH extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final ea8 c;
    @Nullable
    public gi8 d;
    public final TbImageView e;
    public final TextView f;
    public final View.OnClickListener g;
    public final View.OnLongClickListener h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplyPendantVH a;

        public a(EmojiReplyPendantVH emojiReplyPendantVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplyPendantVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplyPendantVH;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && this.a.c != null) {
                yi8.f(this.a.c, this.a.d.d(), this.a.d.b(), 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiReplyPendantVH a;

        public b(EmojiReplyPendantVH emojiReplyPendantVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiReplyPendantVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiReplyPendantVH;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.d != null && this.a.c != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(CriusAttrConstants.POSITION, Integer.valueOf(this.a.d.c()));
                    this.a.c.d(new AbilityItem("open_emoji_detail", hashMap, null), this.a.d.b(), null);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiReplyPendantVH(@NonNull View view2, @Nullable ea8 ea8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, ea8Var};
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
        this.g = new a(this);
        this.h = new b(this);
        this.c = ea8Var;
        view2.setOnClickListener(this.g);
        view2.setOnLongClickListener(this.h);
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909b1);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909b2);
        h(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void f(v98 v98Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, v98Var, context, i) == null) && (v98Var instanceof gi8)) {
            gi8 gi8Var = (gi8) v98Var;
            this.d = gi8Var;
            gi8Var.e(i);
            EmojiData d = this.d.d();
            this.e.startLoad(d.getContent());
            this.f.setText(String.valueOf(d.getAllNum()));
            h(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            gi8 gi8Var = this.d;
            if (gi8Var != null && gi8Var.d().hasReplied()) {
                EMManager.from(this.f).setTextColor(R.color.CAM_X0304);
                EMManager.from(this.itemView).setCorner(R.string.J_X01).setAlpha(R.string.A_X11).setBackGroundColor(R.color.CAM_X0302);
                return;
            }
            EMManager.from(this.f).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.itemView).setCorner(R.string.J_X01).setAlpha(R.string.A_X06).setBackGroundColor(R.color.CAM_X0208);
        }
    }
}
