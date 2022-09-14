package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.gm8;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class t39 extends i39<q49> implements a49, b49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RichTextEditor t;
    @Nullable
    public z39 u;
    @NonNull
    public final i59 v;
    public final RichImageItem.f w;

    /* loaded from: classes5.dex */
    public class a implements RichImageItem.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t39 a;

        public a(t39 t39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t39Var;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageFileInfo, view2) == null) || this.a.b == null) {
                return;
            }
            if (ListUtils.isEmpty(this.a.v.f().getChosedFiles())) {
                this.a.b.h();
            }
            this.a.b.x(new int[]{10, 34});
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t39(TbPageContext<?> tbPageContext, @NonNull i59 i59Var, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        super(tbPageContext, q49.class, x29Var, e59Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, i59Var, x29Var, e59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (x29) objArr2[2], (e59) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.v = i59Var;
        i59Var.c(this);
    }

    @Override // com.baidu.tieba.i39
    public void F(Editable editable) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.F(editable);
            WriteData writeData = this.e;
            if (writeData == null || (richTextEditor = this.t) == null) {
                return;
            }
            writeData.setRichContentData(richTextEditor.getPlainTextContentData());
        }
    }

    @Override // com.baidu.tieba.i39
    public void H(r05 r05Var) {
        RichTextEditor richTextEditor;
        ImageFileInfo b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r05Var) == null) || this.b == null || (richTextEditor = this.t) == null || richTextEditor.getVisibility() != 0 || (b = this.v.b(this.b, r05Var)) == null) {
            return;
        }
        U(b);
        this.b.h();
        this.b.x(new int[]{10, 34});
    }

    @Override // com.baidu.tieba.i39
    public void I(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.h(arrayList);
    }

    @Override // com.baidu.tieba.i39
    public void J(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.l(arrayList);
    }

    @Override // com.baidu.tieba.i39
    @Nullable
    public ArrayList<AtSelectData> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor == null || richTextEditor.getVisibility() != 0) {
                return null;
            }
            return this.t.getAtDataInText();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i39
    @Nullable
    public EditText M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor == null || richTextEditor.getVisibility() != 0) {
                return null;
            }
            return this.t.getLastFocusEdit();
        }
        return (EditText) invokeV.objValue;
    }

    public void T(z39 z39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, z39Var) == null) {
            this.u = z39Var;
        }
    }

    public final void U(ImageFileInfo imageFileInfo) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, imageFileInfo) == null) || (richTextEditor = this.t) == null || this.e == null) {
            return;
        }
        richTextEditor.t(imageFileInfo);
        this.e.setRichContentData(this.t.getPlainTextContentData());
    }

    public void V(gm8.f fVar) {
        b59 b59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || (b59Var = this.l) == null) {
            return;
        }
        b59Var.o(fVar);
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || str == null || this.b == null || this.t == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(str);
        writeImagesInfo.updateQuality();
        if (writeImagesInfo.getChosedFiles() == null || writeImagesInfo.getChosedFiles().size() <= 0) {
            return;
        }
        ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
        int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
        this.v.f().getChosedFiles().remove(originalImgIndex);
        this.v.f().getChosedFiles().add(originalImgIndex, imageFileInfo);
        this.t.p(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
        this.b.x(new int[]{10, 34});
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == null || this.b == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(str);
        writeImagesInfo.updateQuality();
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            for (ImageFileInfo imageFileInfo : chosedFiles) {
                this.v.f().addChooseFile(imageFileInfo);
                U(imageFileInfo);
            }
        }
        this.b.x(new int[]{10, 34});
        this.b.h();
    }

    @Override // com.baidu.tieba.e49
    public void a(boolean z) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || z || (richTextEditor = this.t) == null || richTextEditor.getLastFocusEdit() == null) {
            return;
        }
        this.t.getLastFocusEdit().clearFocus();
    }

    @Override // com.baidu.tieba.d49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, writeData) == null) {
            this.v.d(writeData);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor == null || richTextEditor.getVisibility() != 0) {
                return;
            }
            this.t.setWriteImagesInfo(this.v.f());
            writeData.setRichContentData(this.t.getPostServerContentData());
            writeData.setServerRichContent(this.t.getPostServerContentData());
            writeData.setRichTextEditorMode(true);
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.c();
            this.v.p(this);
        }
    }

    @Override // com.baidu.tieba.d49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) {
            writeData.setRichTextEditorMode(true);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.e49
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.b49
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            s(str);
        }
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.y39, com.baidu.tieba.d49
    public void h(@NonNull f49 f49Var) {
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, f49Var) == null) {
            super.h(f49Var);
            z39 z39Var = this.u;
            if (z39Var != null) {
                z39Var.l(this);
            }
            WriteImagesInfo f = this.v.f();
            if (f.size() <= 0 || (chosedFiles = f.getChosedFiles()) == null) {
                return;
            }
            for (ImageFileInfo imageFileInfo : chosedFiles) {
                if (imageFileInfo != null) {
                    U(imageFileInfo);
                }
            }
            f49 f49Var2 = this.b;
            if (f49Var2 != null) {
                f49Var2.h();
                this.b.x(new int[]{10, 34});
            }
        }
    }

    @Override // com.baidu.tieba.b49
    public void i(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            W(str);
        }
    }

    @Override // com.baidu.tieba.e49
    public void j() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (richTextEditor = this.t) == null || richTextEditor.getLastFocusEdit() == null) {
            return;
        }
        this.t.getLastFocusEdit().requestFocus();
    }

    @Override // com.baidu.tieba.d49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, writeData) == null) || writeData.getWriteImagesInfo() == null) {
            return;
        }
        this.v.q(writeData.getWriteImagesInfo());
        RichTextEditor richTextEditor = this.t;
        if (richTextEditor != null) {
            richTextEditor.setWriteImagesInfo(writeData.getWriteImagesInfo());
            this.t.s(writeData.getRichContentData());
        }
        WriteData writeData2 = this.e;
        if (writeData2 != null) {
            writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
            this.e.setRichContentData(writeData.getRichContentData());
        }
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.y39, com.baidu.tieba.d49
    public void l(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, intent, writeData) == null) {
            super.l(bundle, intent, writeData);
            this.v.g(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.e49
    public void m() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (richTextEditor = this.t) == null) {
            return;
        }
        this.n.f(richTextEditor.getLastFocusEdit(), false);
    }

    @Override // com.baidu.tieba.e49
    public EditText o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                return richTextEditor.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048600, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.v.l(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.d49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            super.onChangeSkinType(i);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.w();
            }
        }
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v.n(bundle);
        }
    }

    @Override // com.baidu.tieba.a49
    public void onUpdate(Object obj) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, obj) == null) && (obj instanceof SelectForumData) && (richTextEditor = this.t) != null) {
            richTextEditor.setForumId(dh.g(((SelectForumData) obj).forumId, 0L));
        }
    }

    @Override // com.baidu.tieba.d49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04d0, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091a3c);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f09014e);
            RichTextEditor richTextEditor = (RichTextEditor) this.c.findViewById(R.id.obfuscated_res_0x7f091c1d);
            this.t = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.v.f());
            this.t.setOutImageOperateListener(this.w);
            this.t.setOnSpanGroupChangedListener(this.p);
            this.t.setEditOnClickListener(this.o);
            this.t.setEditOnFocusChangeListener(this.s);
            this.t.setBigEmotionSpanHandler(this.q);
            this.t.k(this.r);
            WriteData writeData = this.e;
            if (writeData != null) {
                this.t.setForumId(dh.g(writeData.getForumId(), 0L));
            }
            this.t.n();
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            return (richTextEditor == null || richTextEditor.u()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b49
    public void s(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            X(str);
        }
    }

    @Override // com.baidu.tieba.b49
    public void t(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            X(str);
        }
    }
}
