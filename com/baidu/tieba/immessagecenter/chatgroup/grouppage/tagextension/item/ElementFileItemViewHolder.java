package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ca8;
import com.baidu.tieba.da8;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.j98;
import com.baidu.tieba.r78;
import com.baidu.tieba.t78;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ElementFileItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;
    @Nullable
    public j98 f;
    @Nullable
    public Context g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da8 a;
        public final /* synthetic */ ElementFileItemViewHolder b;

        public a(ElementFileItemViewHolder elementFileItemViewHolder, da8 da8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementFileItemViewHolder, da8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = elementFileItemViewHolder;
            this.a = da8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.f != null && this.b.f.q()) {
                    this.b.c.setText(this.b.f.b());
                    this.b.x();
                    this.b.e.setVisibility(8);
                    this.b.d.setVisibility(8);
                    z = false;
                } else {
                    z = true;
                    this.b.u();
                    if (this.a != null && this.b.f != null && this.a.a(this.b.getAdapterPosition(), this.b.f.l(), this.b.f.f())) {
                        this.b.t();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921800, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements r78 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext a;

        public b(ElementFileItemViewHolder elementFileItemViewHolder, BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementFileItemViewHolder, ext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ext;
        }

        @Override // com.baidu.tieba.r78
        public void onFinish(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.setPicPath(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementFileItemViewHolder(@NonNull View view2, @Nullable da8 da8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, da8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092233);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092232);
        this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092267);
        view2.setOnClickListener(new a(this, da8Var));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            t();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(ca8 ca8Var, Context context, int i) {
        String b2;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, ca8Var, context, i) == null) {
            super.f(ca8Var, context, i);
            this.g = context;
            if (ca8Var instanceof j98) {
                j98 j98Var = (j98) ca8Var;
                this.f = j98Var;
                if (j98Var.b != null && (optsDTO = j98Var.c) != null && optsDTO.getExt() != null && this.f.p()) {
                    BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = this.f.c.getExt();
                    b2 = this.f.b.getName() + "：";
                    this.e.setVisibility(0);
                    this.d.setVisibility(0);
                    String picPath = ext.getPicPath();
                    ext.setPicPath("");
                    this.e.setImageURI(Uri.parse(picPath));
                    t78.a(picPath, 1024, 1024, new b(this, ext));
                } else {
                    b2 = this.f.b();
                    this.e.setVisibility(8);
                    this.d.setVisibility(8);
                }
                this.c.setText(b2);
            }
            t();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            ii.Q(this.g, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f0811c8, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
            g35 d = g35.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.i(R.color.CAM_X0905);
            g35 d2 = g35.d(this.c);
            d2.B(R.dimen.T_X08);
            d2.w(R.color.CAM_X0304);
            d2.C(R.string.F_X01);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && s() && this.g != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
            writeImagesInfo.mIsFromIm = true;
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.g, writeImagesInfo.toJsonString(), true, false);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setResourceType(1);
            albumFloatActivityConfig.setCanSelectOnlyVideo(false);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanSelectGif(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setOnlySelectPngAndJpeg(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public final void x() {
        j98 j98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j98Var = this.f) != null) {
            j98Var.r(false);
            this.e.setImageURI(null);
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = this.f.c;
            if (optsDTO != null && optsDTO.getExt() != null) {
                BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = this.f.c.getExt();
                ext.setPicPath("");
                ext.setPicSize("");
            }
        }
    }
}
