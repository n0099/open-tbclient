package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.fn8;
import com.baidu.tieba.fq8;
import com.baidu.tieba.fr8;
import com.baidu.tieba.go8;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AddEmojiPendantVH extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final fn8 c;
    @Nullable
    public fq8 d;
    public final TbImageView e;
    public final TextView f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddEmojiPendantVH a;

        public a(AddEmojiPendantVH addEmojiPendantVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addEmojiPendantVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addEmojiPendantVH;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && this.a.c != null) {
                go8.e(this.a.c, 2, this.a.d.b());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddEmojiPendantVH(@NonNull View view2, @Nullable fn8 fn8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, fn8Var};
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
        this.c = fn8Var;
        view2.setOnClickListener(new a(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds14);
        view2.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909a6);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909a7);
        i(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void g(fr8 fr8Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, fr8Var, context, i) == null) {
            if (fr8Var instanceof fq8) {
                this.d = (fq8) fr8Var;
            }
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f0800e2);
            this.f.setVisibility(8);
            i(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.i(i);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f0800e2, R.color.CAM_X0107, null);
            EMManager.from(this.itemView).setCorner(R.string.J_X01).setAlpha(R.string.A_X06).setBackGroundColor(R.color.CAM_X0208);
        }
    }
}
