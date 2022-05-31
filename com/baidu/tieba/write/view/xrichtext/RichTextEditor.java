package com.baidu.tieba.write.view.xrichtext;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hu4;
import com.repackage.jv8;
import com.repackage.li;
import com.repackage.mg;
import com.repackage.rb;
import com.repackage.wq4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class RichTextEditor extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnFocusChangeListener a;
    public SpanGroupEditText b;
    public int c;
    public WriteImagesInfo d;
    public View.OnClickListener e;
    public hu4.a f;
    public long g;
    public View.OnFocusChangeListener h;
    public TextWatcher i;
    public TbFaceManager.a j;
    public final RichImageItem.f k;

    /* loaded from: classes4.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichTextEditor a;

        public a(RichTextEditor richTextEditor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextEditor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richTextEditor;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    this.a.b = (SpanGroupEditText) view2;
                    RichTextEditor richTextEditor = this.a;
                    richTextEditor.y(richTextEditor.b);
                }
                if (this.a.h != null) {
                    this.a.h.onFocusChange(view2, z);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ RichTextEditor b;

        public b(RichTextEditor richTextEditor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextEditor, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = richTextEditor;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.b != null) {
                        this.b.b.requestFocus();
                        this.b.b.setSelection(this.a);
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements RichImageItem.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichTextEditor a;

        public c(RichTextEditor richTextEditor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextEditor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richTextEditor;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, imageFileInfo, view2) == null) {
                this.a.n(view2);
                this.a.d.getChosedFiles().remove(imageFileInfo);
                if (imageFileInfo.isTempFile()) {
                    rb.f().a(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                if (this.a.getContext() instanceof WriteActivity) {
                    if (ListUtils.isEmpty(this.a.d.getChosedFiles())) {
                        ((WriteActivity) this.a.getContext()).refreshPostButton();
                    }
                    ((WriteActivity) this.a.getContext()).refreshImageLauncher();
                    ((WriteActivity) this.a.getContext()).refreshVideoLauncher();
                }
            }
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) || imageFileInfo == null || imageFileInfo.getImageType() == 1) {
                return;
            }
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.copyFrom(this.a.d);
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            writeImagesInfo.setChosedFiles(linkedList);
            writeImagesInfo.setOriginalImgIndex(this.a.d.getChosedFiles().indexOf(imageFileInfo));
            writeImagesInfo.setOriginalImgViewIndex(this.a.indexOfChild(view2));
            new WriteMulitImageActivityConfig((Activity) this.a.getContext(), 12012, writeImagesInfo, 0).start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RichTextEditor(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getTextContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof SpanGroupEditText) {
                    SpanGroupEditText spanGroupEditText = (SpanGroupEditText) childAt;
                    if (spanGroupEditText.getText() != null) {
                        i += spanGroupEditText.getText().length();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void g(@Nullable List<AtSelectData> list) {
        ArrayList<AtSelectData> atDataInText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof SpanGroupEditText) && childAt != this.b && (atDataInText = ((SpanGroupEditText) childAt).getAtDataInText()) != null && !atDataInText.isEmpty()) {
                arrayList.removeAll(atDataInText);
            }
        }
        this.b.b(arrayList);
    }

    @NonNull
    public ArrayList<AtSelectData> getAtDataInText() {
        InterceptResult invokeV;
        ArrayList<AtSelectData> atDataInText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof SpanGroupEditText) {
                    SpanGroupEditText spanGroupEditText = (SpanGroupEditText) childAt;
                    if (spanGroupEditText.getText() != null && (atDataInText = spanGroupEditText.getAtDataInText()) != null && atDataInText.size() > 0) {
                        arrayList.addAll(atDataInText);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public EditText getLastFocusEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (EditText) invokeV.objValue;
    }

    public List<Object> getPlainTextContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? p(false) : (List) invokeV.objValue;
    }

    public List<Object> getPostServerContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? p(true) : (List) invokeV.objValue;
    }

    public SpanGroupEditText h(int i, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, charSequence)) == null) {
            SpanGroupEditText l = l("");
            if (!TextUtils.isEmpty(charSequence)) {
                l.setText(TbFaceManager.i().t(getContext(), (String) charSequence, this.j));
            }
            setLayoutTransition(null);
            addView(l, i, new LinearLayout.LayoutParams(-1, -2));
            return l;
        }
        return (SpanGroupEditText) invokeIL.objValue;
    }

    public void i(int i, @NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, imageFileInfo) == null) {
            RichImageItem richImageItem = new RichImageItem(getContext());
            richImageItem.setImageFileInfo(imageFileInfo);
            imageFileInfo.setExtra(String.valueOf(i));
            richImageItem.setItemOperateListener(this.k);
            addView(richImageItem, i, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void j(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textWatcher) == null) {
            this.i = textWatcher;
        }
    }

    public void k(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) childAt).e(list);
                }
            }
        }
    }

    public SpanGroupEditText l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(getContext());
            spanGroupEditText.setBackgroundResource(0);
            spanGroupEditText.setPadding(0, 0, 0, 0);
            spanGroupEditText.setLineSpacing(li.f(getContext(), R.dimen.M_T_X002), 1.0f);
            jv8.l(spanGroupEditText, R.drawable.obfuscated_res_0x7f0804ae);
            spanGroupEditText.setTextSize(0, getResources().getDimension(R.dimen.T_X06));
            wq4.d(spanGroupEditText).v(R.color.CAM_X0105);
            spanGroupEditText.setDrawingCacheEnabled(false);
            spanGroupEditText.setGravity(51);
            spanGroupEditText.setHint(str);
            spanGroupEditText.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            spanGroupEditText.setOnFocusChangeListener(this.a);
            spanGroupEditText.setOnSpanGroupChangedListener(this.f);
            spanGroupEditText.setForumId(this.g);
            spanGroupEditText.setOnClickListener(this.e);
            spanGroupEditText.addTextChangedListener(this.i);
            spanGroupEditText.setTag(R.id.obfuscated_res_0x7f090fcf, Boolean.TRUE);
            return spanGroupEditText;
        }
        return (SpanGroupEditText) invokeL.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SpanGroupEditText l = l(getContext().getString(R.string.obfuscated_res_0x7f0f0e5f));
            addView(l, new LinearLayout.LayoutParams(-1, -2));
            this.b = l;
        }
    }

    public final void n(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            this.c = indexOfChild(view2);
            removeView(view2);
            u();
            x();
        }
    }

    public void o(@NonNull ImageFileInfo imageFileInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, imageFileInfo, i) == null) {
            View childAt = getChildAt(i);
            if (childAt instanceof RichImageItem) {
                ((RichImageItem) childAt).setImageFileInfo(imageFileInfo);
            }
        }
    }

    public final List<Object> p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof SpanGroupEditText) {
                    if (z) {
                        arrayList.add(((SpanGroupEditText) childAt).getToServerContent());
                    } else {
                        arrayList.add(((SpanGroupEditText) childAt).getPlainTextContent());
                    }
                } else if (childAt instanceof RichImageItem) {
                    arrayList.add(((RichImageItem) childAt).getImageFileInfo());
                }
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    public void q() {
        InputMethodManager inputMethodManager;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method")) == null || (spanGroupEditText = this.b) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(spanGroupEditText.getWindowToken(), 0);
    }

    public void r(List<Object> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof String) {
                this.b.setText(TbFaceManager.i().t(getContext(), (String) obj, this.j));
                if (this.b.getText() != null) {
                    SpanGroupEditText spanGroupEditText = this.b;
                    spanGroupEditText.setSelection(spanGroupEditText.getText().length());
                }
            } else if (obj instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) obj;
                WriteImagesInfo writeImagesInfo = this.d;
                if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.d.getChosedFiles().size()) {
                            break;
                        }
                        ImageFileInfo imageFileInfo2 = this.d.getChosedFiles().get(i2);
                        if (StringHelper.equals(imageFileInfo2.getFilePath(), imageFileInfo.getFilePath()) && StringHelper.equals(imageFileInfo2.getExtra(), imageFileInfo.getExtra())) {
                            imageFileInfo = imageFileInfo2;
                            break;
                        }
                        i2++;
                    }
                }
                s(imageFileInfo);
            }
        }
    }

    public void s(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, imageFileInfo) == null) {
            String selectionBeforePlainTextContent = this.b.getSelectionBeforePlainTextContent();
            String selectionAfterPlainTextContent = this.b.getSelectionAfterPlainTextContent();
            int indexOfChild = indexOfChild(this.b);
            if (selectionAfterPlainTextContent.length() == 0) {
                int i = indexOfChild + 1;
                SpanGroupEditText h = h(i, "");
                i(i, imageFileInfo);
                w(h, 0);
            } else if (selectionBeforePlainTextContent.length() == 0) {
                h(indexOfChild, "");
                i(indexOfChild + 1, imageFileInfo);
                this.b.setHint("");
            } else {
                this.b.setText(TbFaceManager.i().t(getContext(), selectionBeforePlainTextContent, this.j));
                int i2 = indexOfChild + 1;
                SpanGroupEditText h2 = h(i2, selectionAfterPlainTextContent);
                i(i2, imageFileInfo);
                w(h2, 0);
            }
            x();
            q();
        }
    }

    public void setBigEmotionSpanHandler(TbFaceManager.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void setEditOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void setEditOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onFocusChangeListener) == null) {
            this.h = onFocusChangeListener;
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.g = j;
        }
    }

    public void setOnSpanGroupChangedListener(hu4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, writeImagesInfo) == null) {
            this.d = writeImagesInfo;
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (getChildCount() < 1) {
                return true;
            }
            if (getChildCount() == 1) {
                return TextUtils.isEmpty(((SpanGroupEditText) getChildAt(0)).getPlainTextContent());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            View childAt = getChildAt(this.c - 1);
            View childAt2 = getChildAt(this.c);
            if ((childAt instanceof SpanGroupEditText) && (childAt2 instanceof SpanGroupEditText)) {
                SpanGroupEditText spanGroupEditText = (SpanGroupEditText) childAt;
                SpanGroupEditText spanGroupEditText2 = (SpanGroupEditText) childAt2;
                int length = spanGroupEditText.getText().toString() != null ? spanGroupEditText.getText().toString().length() : 0;
                String plainTextContent = spanGroupEditText.getPlainTextContent();
                String plainTextContent2 = spanGroupEditText2.getPlainTextContent();
                if (plainTextContent2.length() > 0) {
                    if (plainTextContent.length() <= 0) {
                        plainTextContent = plainTextContent2;
                    } else if (!plainTextContent.endsWith("\n") && !plainTextContent2.startsWith("\n")) {
                        plainTextContent = plainTextContent + "\n" + plainTextContent2;
                    } else {
                        plainTextContent = plainTextContent + plainTextContent2;
                    }
                }
                removeView(spanGroupEditText2);
                spanGroupEditText.setText(TbFaceManager.i().t(getContext(), plainTextContent, this.j));
                w(spanGroupEditText, length);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof RichImageItem) {
                    ((RichImageItem) childAt).f();
                } else if (childAt instanceof SpanGroupEditText) {
                    wq4.d(childAt).v(R.color.CAM_X0105);
                    ((SpanGroupEditText) childAt).setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
                }
            }
        }
    }

    public final void w(@NonNull SpanGroupEditText spanGroupEditText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, spanGroupEditText, i) == null) {
            this.b = spanGroupEditText;
            mg.a().postDelayed(new b(this, i), 300L);
        }
    }

    public final void x() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        if (childAt instanceof SpanGroupEditText) {
            if (childCount > 1) {
                ((SpanGroupEditText) childAt).setHint("");
            } else {
                ((SpanGroupEditText) childAt).setHint(getContext().getString(R.string.obfuscated_res_0x7f0f0e5f));
            }
        }
    }

    public final void y(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, spanGroupEditText) == null) {
            int textContentLength = 2000 - getTextContentLength();
            if (textContentLength <= 0) {
                textContentLength = 1;
            }
            spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(textContentLength)});
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RichTextEditor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextEditor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.k = new c(this);
        setOrientation(1);
        setLayoutTransition(null);
        setDividerDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080fe0));
        setShowDividers(2);
        this.a = new a(this);
    }
}
