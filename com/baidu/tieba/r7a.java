package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.u05;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.model.StickerModel;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class r7a implements paa, MultiImagePagerAdapter.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteMultiImgsActivity> a;
    public q7a b;
    public MultiImagePagerAdapter c;
    public int d;
    public ForumWriteData e;
    public u05 f;
    public StickerModel g;
    public int h;
    public WriteImagesInfo i;
    public int j;
    public HashMap<String, String> k;
    public PermissionJudgePolicy l;

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r7a a;

        public a(r7a r7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r7aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getTag() != null) {
                this.a.c.i(Integer.parseInt(view2.getTag().toString()), this.a.c());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r7a a;

        public b(r7a r7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r7aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            Activity pageActivity = this.a.a.getPageActivity();
            if (this.a.l == null) {
                this.a.l = new PermissionJudgePolicy();
            }
            this.a.l.clearRequestPermissionList();
            this.a.l.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.a.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.a.c.g(false);
            if (this.a.b == null) {
                return;
            }
            if (this.a.i != null && this.a.i.getChosedFiles() != null && this.a.i.getChosedFiles().size() > 0 && this.a.i.isOriginalImg() && this.a.h > 0 && this.a.o()) {
                this.a.b.q();
            } else {
                this.a.b.k(true, this.a.i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ r7a c;

        public c(r7a r7aVar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r7aVar;
            this.a = i;
            this.b = z;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                if (this.c.f != null) {
                    this.c.f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.c.c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.i(this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r7a a;

        public d(r7a r7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r7aVar;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) && this.a.f != null) {
                this.a.f.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ r7a b;

        public e(r7a r7aVar, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r7aVar;
            this.a = bitmap;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                if (this.b.f != null) {
                    this.b.f.dismiss();
                }
                this.b.b.i(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r7a a;

        public f(r7a r7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r7aVar;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) && this.a.f != null) {
                this.a.f.dismiss();
            }
        }
    }

    public r7a(TbPageContext<WriteMultiImgsActivity> tbPageContext, q7a q7aVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, q7aVar, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = 0;
        this.h = 0;
        this.i = null;
        this.j = TbadkCoreApplication.getInst().getSkinType();
        this.k = new HashMap<>();
        this.a = tbPageContext;
        this.b = q7aVar;
        x(bundle);
        y();
        A();
    }

    @Override // com.baidu.tieba.paa
    public void e(List<String> list) {
        q7a q7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && (q7aVar = this.b) != null) {
            q7aVar.a(list);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.b.e.setmDisallowSlip(true);
            } else {
                this.b.e.setmDisallowSlip(false);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.b
    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            p(i, z);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.a.getContext() != null) {
                ii.P(this.a.getContext(), R.string.obfuscated_res_0x7f0f0d30);
                return;
            }
            return;
        }
        if (this.g == null) {
            this.g = new StickerModel(this.a);
        }
        this.g.loadData();
        this.g.W(this);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s();
            r(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.b
    public boolean c() {
        InterceptResult invokeV;
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            q7a q7aVar = this.b;
            if (q7aVar != null && (stickerLayout = q7aVar.f) != null && !ListUtils.isEmpty(stickerLayout.getStickerViews())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h++;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (stickerModel = this.g) != null) {
            stickerModel.destroy();
        }
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public final void y() {
        q7a q7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (q7aVar = this.b) == null) {
            return;
        }
        z6a z6aVar = q7aVar.d;
        if (z6aVar != null) {
            z6aVar.y(new a(this));
        }
        TextView textView = this.b.g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.i.getChosedFiles() != null && this.i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.i.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.k.get(next.getFilePath()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(int i, boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (tbPageContext = this.a) != null && tbPageContext.getPageActivity() != null) {
            if (this.f == null) {
                u05 u05Var = new u05(this.a.getPageActivity());
                this.f = u05Var;
                u05Var.setMessageId(R.string.obfuscated_res_0x7f0f0e05);
                this.f.setPositiveButton(R.string.alert_yes_button, new c(this, i, z));
                this.f.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new d(this));
                this.f.create(this.a);
            }
            this.f.show();
        }
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.c.l() || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f == null) {
                u05 u05Var = new u05(this.a.getPageActivity());
                this.f = u05Var;
                u05Var.setMessageId(R.string.obfuscated_res_0x7f0f0e05);
                this.f.setPositiveButton(R.string.alert_yes_button, new e(this, bitmap));
                this.f.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new f(this));
                this.f.create(this.a);
            }
            this.f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void x(Bundle bundle) {
        String str;
        int i;
        Intent intent;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            if (bundle != null) {
                str = bundle.getString("OutState_Write_Img_Info");
                intExtra = bundle.getInt("OutState_Current_Index");
                this.d = bundle.getInt("OutState_Write_Entrance");
                this.e = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
                this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.a;
                if (tbPageContext != null && tbPageContext.getPageActivity() != null && (intent = this.a.getPageActivity().getIntent()) != null) {
                    str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                    intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                    this.d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                    this.e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
                    this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
                } else {
                    str = null;
                    i = -1;
                    if (str == null && i != -1) {
                        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                        this.i = writeImagesInfo;
                        writeImagesInfo.parseJson(str);
                        z();
                        q7a q7aVar = this.b;
                        if (q7aVar != null && q7aVar.e != null) {
                            MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.a.getOrignalPage(), this.b.e, this.i.getChosedFiles(), i, this, this.b, this.i.mIsFromIm);
                            this.c = multiImagePagerAdapter;
                            this.b.e.setAdapter(multiImagePagerAdapter);
                            int k = this.c.k();
                            this.b.e.setCurrentItem(k, true);
                            if (k == 0) {
                                this.c.onPageSelected(0);
                            }
                            this.b.p(this.i);
                            return;
                        }
                        return;
                    }
                }
            }
            i = intExtra;
            if (str == null) {
            }
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (writeImagesInfo = this.i) != null && writeImagesInfo.isOriginalImg() && this.i.getChosedFiles() != null && this.i.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.i.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.k.put(next.getFilePath(), "1");
                }
            }
        }
    }
}
