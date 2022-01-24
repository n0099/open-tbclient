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
import c.a.d.f.a.d;
import c.a.d.f.p.n;
import c.a.s0.s.k0.s.a;
import c.a.t0.p4.e;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.j;
import c.a.t0.p4.s;
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
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes13.dex */
public class RichTextEditor extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View.OnFocusChangeListener f49772e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupEditText f49773f;

    /* renamed from: g  reason: collision with root package name */
    public int f49774g;

    /* renamed from: h  reason: collision with root package name */
    public WriteImagesInfo f49775h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f49776i;

    /* renamed from: j  reason: collision with root package name */
    public a.InterfaceC0881a f49777j;
    public long k;
    public View.OnFocusChangeListener l;
    public TextWatcher m;
    public TbFaceManager.a n;
    public final RichImageItem.f o;

    /* loaded from: classes13.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RichTextEditor f49778e;

        public a(RichTextEditor richTextEditor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextEditor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49778e = richTextEditor;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    this.f49778e.f49773f = (SpanGroupEditText) view;
                    RichTextEditor richTextEditor = this.f49778e;
                    richTextEditor.l(richTextEditor.f49773f);
                }
                if (this.f49778e.l != null) {
                    this.f49778e.l.onFocusChange(view, z);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RichTextEditor f49780f;

        public b(RichTextEditor richTextEditor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextEditor, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49780f = richTextEditor;
            this.f49779e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f49780f.f49773f != null) {
                        this.f49780f.f49773f.requestFocus();
                        this.f49780f.f49773f.setSelection(this.f49779e);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richTextEditor;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, imageFileInfo, view) == null) {
                this.a.g(view);
                this.a.f49775h.getChosedFiles().remove(imageFileInfo);
                if (imageFileInfo.isTempFile()) {
                    d.f().a(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                if (this.a.getContext() instanceof WriteActivity) {
                    if (ListUtils.isEmpty(this.a.f49775h.getChosedFiles())) {
                        ((WriteActivity) this.a.getContext()).refreshPostButton();
                    }
                    ((WriteActivity) this.a.getContext()).refreshImageLauncher();
                    ((WriteActivity) this.a.getContext()).refreshVideoLauncher();
                }
            }
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view) == null) || imageFileInfo == null || imageFileInfo.getImageType() == 1) {
                return;
            }
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.copyFrom(this.a.f49775h);
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            writeImagesInfo.setChosedFiles(linkedList);
            writeImagesInfo.setOriginalImgIndex(this.a.f49775h.getChosedFiles().indexOf(imageFileInfo));
            writeImagesInfo.setOriginalImgViewIndex(this.a.indexOfChild(view));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof SpanGroupEditText) {
                    SpanGroupEditText spanGroupEditText = (SpanGroupEditText) childAt;
                    if (spanGroupEditText.getText() != null) {
                        i2 += spanGroupEditText.getText().length();
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void addAtSpanGroupList(@Nullable List<AtSelectData> list) {
        ArrayList<AtSelectData> atDataInText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof SpanGroupEditText) && childAt != this.f49773f && (atDataInText = ((SpanGroupEditText) childAt).getAtDataInText()) != null && !atDataInText.isEmpty()) {
                arrayList.removeAll(atDataInText);
            }
        }
        this.f49773f.addAtSpanGroupList(arrayList);
    }

    public SpanGroupEditText addEditTextAtIndex(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence)) == null) {
            SpanGroupEditText createEditText = createEditText("");
            if (!TextUtils.isEmpty(charSequence)) {
                createEditText.setText(TbFaceManager.e().l(getContext(), (String) charSequence, this.n));
            }
            setLayoutTransition(null);
            addView(createEditText, i2, new LinearLayout.LayoutParams(-1, -2));
            return createEditText;
        }
        return (SpanGroupEditText) invokeIL.objValue;
    }

    public void addImageViewAtIndex(int i2, @NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, imageFileInfo) == null) {
            RichImageItem richImageItem = new RichImageItem(getContext());
            richImageItem.setImageFileInfo(imageFileInfo);
            imageFileInfo.setExtra(String.valueOf(i2));
            richImageItem.setItemOperateListener(this.o);
            addView(richImageItem, i2, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textWatcher) == null) {
            this.m = textWatcher;
        }
    }

    public void checkAndRemoveUnusedAtSpanGroup(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) childAt).checkAndRemoveUnusedAtSpanGroup(list);
                }
            }
        }
    }

    public SpanGroupEditText createEditText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(getContext());
            spanGroupEditText.setBackgroundResource(0);
            spanGroupEditText.setPadding(0, 0, 0, 0);
            spanGroupEditText.setLineSpacing(n.f(getContext(), e.M_T_X002), 1.0f);
            s.l(spanGroupEditText, f.edittext_cursor);
            spanGroupEditText.setTextSize(0, getResources().getDimension(e.T_X06));
            c.a.s0.s.u.c.d(spanGroupEditText).v(c.a.t0.p4.d.CAM_X0105);
            spanGroupEditText.setDrawingCacheEnabled(false);
            spanGroupEditText.setGravity(51);
            spanGroupEditText.setHint(str);
            spanGroupEditText.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            spanGroupEditText.setOnFocusChangeListener(this.f49772e);
            spanGroupEditText.setOnSpanGroupChangedListener(this.f49777j);
            spanGroupEditText.setForumId(this.k);
            spanGroupEditText.setOnClickListener(this.f49776i);
            spanGroupEditText.addTextChangedListener(this.m);
            spanGroupEditText.setTag(g.key_rich_text_edit, Boolean.TRUE);
            return spanGroupEditText;
        }
        return (SpanGroupEditText) invokeL.objValue;
    }

    public void createFirstEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpanGroupEditText createEditText = createEditText(getContext().getString(j.picText_default_content_hint));
            addView(createEditText, new LinearLayout.LayoutParams(-1, -2));
            this.f49773f = createEditText;
        }
    }

    public void editImage(@NonNull ImageFileInfo imageFileInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, imageFileInfo, i2) == null) {
            View childAt = getChildAt(i2);
            if (childAt instanceof RichImageItem) {
                ((RichImageItem) childAt).setImageFileInfo(imageFileInfo);
            }
        }
    }

    public final void g(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.f49774g = indexOfChild(view);
            removeView(view);
            i();
            k();
        }
    }

    @NonNull
    public ArrayList<AtSelectData> getAtDataInText() {
        InterceptResult invokeV;
        ArrayList<AtSelectData> atDataInText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49773f : (EditText) invokeV.objValue;
    }

    public List<Object> getPlainTextContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? h(false) : (List) invokeV.objValue;
    }

    public List<Object> getPostServerContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? h(true) : (List) invokeV.objValue;
    }

    public final List<Object> h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
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

    public void hideKeyBoard() {
        InputMethodManager inputMethodManager;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method")) == null || (spanGroupEditText = this.f49773f) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(spanGroupEditText.getWindowToken(), 0);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View childAt = getChildAt(this.f49774g - 1);
            View childAt2 = getChildAt(this.f49774g);
            if ((childAt instanceof SpanGroupEditText) && (childAt2 instanceof SpanGroupEditText)) {
                SpanGroupEditText spanGroupEditText = (SpanGroupEditText) childAt;
                SpanGroupEditText spanGroupEditText2 = (SpanGroupEditText) childAt2;
                int length = spanGroupEditText.getText().toString() != null ? spanGroupEditText.getText().toString().length() : 0;
                String plainTextContent = spanGroupEditText.getPlainTextContent();
                String plainTextContent2 = spanGroupEditText2.getPlainTextContent();
                if (plainTextContent2.length() > 0) {
                    if (plainTextContent.length() <= 0) {
                        plainTextContent = plainTextContent2;
                    } else if (!plainTextContent.endsWith(StringUtils.LF) && !plainTextContent2.startsWith(StringUtils.LF)) {
                        plainTextContent = plainTextContent + StringUtils.LF + plainTextContent2;
                    } else {
                        plainTextContent = plainTextContent + plainTextContent2;
                    }
                }
                removeView(spanGroupEditText2);
                spanGroupEditText.setText(TbFaceManager.e().l(getContext(), plainTextContent, this.n));
                j(spanGroupEditText, length);
            }
        }
    }

    public void initRichContentData(List<Object> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, list) == null) || list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            if (obj instanceof String) {
                this.f49773f.setText(TbFaceManager.e().l(getContext(), (String) obj, this.n));
                if (this.f49773f.getText() != null) {
                    SpanGroupEditText spanGroupEditText = this.f49773f;
                    spanGroupEditText.setSelection(spanGroupEditText.getText().length());
                }
            } else if (obj instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) obj;
                WriteImagesInfo writeImagesInfo = this.f49775h;
                if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f49775h.getChosedFiles().size()) {
                            break;
                        }
                        ImageFileInfo imageFileInfo2 = this.f49775h.getChosedFiles().get(i3);
                        if (StringHelper.equals(imageFileInfo2.getFilePath(), imageFileInfo.getFilePath()) && StringHelper.equals(imageFileInfo2.getExtra(), imageFileInfo.getExtra())) {
                            imageFileInfo = imageFileInfo2;
                            break;
                        }
                        i3++;
                    }
                }
                insertImage(imageFileInfo);
            }
        }
    }

    public void insertImage(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, imageFileInfo) == null) {
            String selectionBeforePlainTextContent = this.f49773f.getSelectionBeforePlainTextContent();
            String selectionAfterPlainTextContent = this.f49773f.getSelectionAfterPlainTextContent();
            int indexOfChild = indexOfChild(this.f49773f);
            if (selectionAfterPlainTextContent.length() == 0) {
                int i2 = indexOfChild + 1;
                SpanGroupEditText addEditTextAtIndex = addEditTextAtIndex(i2, "");
                addImageViewAtIndex(i2, imageFileInfo);
                j(addEditTextAtIndex, 0);
            } else if (selectionBeforePlainTextContent.length() == 0) {
                addEditTextAtIndex(indexOfChild, "");
                addImageViewAtIndex(indexOfChild + 1, imageFileInfo);
                this.f49773f.setHint("");
            } else {
                this.f49773f.setText(TbFaceManager.e().l(getContext(), selectionBeforePlainTextContent, this.n));
                int i3 = indexOfChild + 1;
                SpanGroupEditText addEditTextAtIndex2 = addEditTextAtIndex(i3, selectionAfterPlainTextContent);
                addImageViewAtIndex(i3, imageFileInfo);
                j(addEditTextAtIndex2, 0);
            }
            k();
            hideKeyBoard();
        }
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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

    public final void j(@NonNull SpanGroupEditText spanGroupEditText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, spanGroupEditText, i2) == null) {
            this.f49773f = spanGroupEditText;
            c.a.d.f.m.e.a().postDelayed(new b(this, i2), 300L);
        }
    }

    public final void k() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        if (childAt instanceof SpanGroupEditText) {
            if (childCount > 1) {
                ((SpanGroupEditText) childAt).setHint("");
            } else {
                ((SpanGroupEditText) childAt).setHint(getContext().getString(j.picText_default_content_hint));
            }
        }
    }

    public final void l(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, spanGroupEditText) == null) {
            int textContentLength = 2000 - getTextContentLength();
            if (textContentLength <= 0) {
                textContentLength = 1;
            }
            spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(textContentLength)});
        }
    }

    public void onSkinChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof RichImageItem) {
                    ((RichImageItem) childAt).onSkinChange();
                } else if (childAt instanceof SpanGroupEditText) {
                    c.a.s0.s.u.c.d(childAt).v(c.a.t0.p4.d.CAM_X0105);
                    ((SpanGroupEditText) childAt).setHintTextColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0110));
                }
            }
        }
    }

    public void setBigEmotionSpanHandler(TbFaceManager.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void setEditOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.f49776i = onClickListener;
        }
    }

    public void setEditOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onFocusChangeListener) == null) {
            this.l = onFocusChangeListener;
        }
    }

    public void setForumId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
            this.k = j2;
        }
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC0881a interfaceC0881a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, interfaceC0881a) == null) {
            this.f49777j = interfaceC0881a;
        }
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, writeImagesInfo) == null) {
            this.f49775h = writeImagesInfo;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextEditor(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49774g = 0;
        this.o = new c(this);
        setOrientation(1);
        setLayoutTransition(null);
        setDividerDrawable(getResources().getDrawable(f.rich_spacer_medium));
        setShowDividers(2);
        this.f49772e = new a(this);
    }
}
