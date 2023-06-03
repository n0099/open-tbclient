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
import com.baidu.tieba.af8;
import com.baidu.tieba.df8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.m75;
import com.baidu.tieba.rh8;
import com.baidu.tieba.sh8;
import com.baidu.tieba.vi;
import com.baidu.tieba.xg8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ElementFileItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;
    @Nullable
    public xg8 f;
    @Nullable
    public Context g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh8 a;
        public final /* synthetic */ ElementFileItemViewHolder b;

        public a(ElementFileItemViewHolder elementFileItemViewHolder, sh8 sh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementFileItemViewHolder, sh8Var};
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
            this.a = sh8Var;
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

    /* loaded from: classes6.dex */
    public class b implements af8 {
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

        @Override // com.baidu.tieba.af8
        public void onFinish(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.setPicPath(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementFileItemViewHolder(@NonNull View view2, @Nullable sh8 sh8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, sh8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922ca);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922c9);
        this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922fe);
        view2.setOnClickListener(new a(this, sh8Var));
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
    public void f(rh8 rh8Var, Context context, int i) {
        String b2;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, rh8Var, context, i) == null) {
            super.f(rh8Var, context, i);
            this.g = context;
            if (rh8Var instanceof xg8) {
                xg8 xg8Var = (xg8) rh8Var;
                this.f = xg8Var;
                if (xg8Var.b != null && (optsDTO = xg8Var.c) != null && optsDTO.getExt() != null && this.f.p()) {
                    BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = this.f.c.getExt();
                    b2 = this.f.b.getName() + "：";
                    this.e.setVisibility(0);
                    this.d.setVisibility(0);
                    String picPath = ext.getPicPath();
                    ext.setPicPath("");
                    this.e.setImageURI(Uri.parse(picPath));
                    df8.a(picPath, 1024, 1024, new b(this, ext));
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
            vi.Q(this.g, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f08135d, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
            m75 d = m75.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.i(R.color.CAM_X0905);
            m75 d2 = m75.d(this.c);
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
        xg8 xg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (xg8Var = this.f) != null) {
            xg8Var.r(false);
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
