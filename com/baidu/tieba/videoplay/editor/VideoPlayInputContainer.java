package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools TU;
    private int TV;
    private int cdL;
    private EditText ctU;
    private LinearLayout ctY;
    private boolean cts;
    private boolean ctt;
    private boolean ctu;
    private int ctv;
    private ImageView fwN;
    private View mBottomLine;
    private TextView mSendView;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cts = false;
        this.ctt = true;
        this.ctu = true;
        this.ctv = -1;
        this.cdL = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.ctY = new LinearLayout(getContext());
        this.ctY.setOrientation(0);
        this.ctY.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.ds90));
        addView(this.ctY, new LinearLayout.LayoutParams(-1, -2));
        er(context);
        cO(context);
        cN(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void er(Context context) {
        this.fwN = new ImageView(context);
        this.fwN.setEnabled(true);
        this.fwN.setPadding(0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds30), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds24));
        this.fwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.ctY.addView(this.fwN, layoutParams);
    }

    private void cO(Context context) {
        this.ctU = new EditText(context);
        this.ctU.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ctU.setMaxLines(4);
        this.ctU.setGravity(16);
        this.ctU.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ctU.setBackgroundResource(R.color.common_color_10022);
        e(this.ctU, R.drawable.edittext_cursor);
        this.ctU.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.ctU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ctU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.ctu) {
                    VideoPlayInputContainer.this.ctu = true;
                    if (VideoPlayInputContainer.this.ctv != -1) {
                        VideoPlayInputContainer.this.ctU.setSelection(VideoPlayInputContainer.this.ctv);
                        VideoPlayInputContainer.this.ctv = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.ctU.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cxG();
            }
        });
        this.ctU.setHint(context.getString(R.string.reply_something));
        this.ctU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.ctU.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.ctY.addView(this.ctU, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void cN(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.mSendView.setText(R.string.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.ctY.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ctU.getSelectionStart() > 0) {
                        String substring = this.ctU.getText().toString().substring(0, this.ctU.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fcz.matcher(substring);
                        if (matcher.find()) {
                            this.ctU.getText().delete(this.ctU.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ctU.getSelectionStart());
                            return;
                        }
                        this.ctU.getText().delete(this.ctU.getSelectionStart() - 1, this.ctU.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.ctU.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ctU.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.ctU.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.ctU.setSelection(VideoPlayInputContainer.this.ctU.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ctU.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cxG();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.amu() == EmotionGroupType.NET_SUG) {
                            a(pVar);
                            return;
                        } else {
                            b(pVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.ctU.getText().toString();
            if (this.ctt && com.baidu.tieba.face.a.wb(obj) >= 10 && getContext() != null) {
                e.ahW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ctU);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cts || pVar.amu() == EmotionGroupType.LOCAL) {
            String obj = this.ctU.getText().toString();
            if (this.ctt && com.baidu.tieba.face.a.wb(obj) >= 10 && getContext() != null) {
                e.ahW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ctU);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        if (this.ctU != null) {
            this.ctU.setFocusable(true);
            this.ctU.setFocusableInTouchMode(true);
            this.ctU.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ctU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cdL = i;
        am.l(this.mBottomLine, R.color.cp_bg_line_c);
        am.d(this.ctU, R.color.cp_cont_f, 2, i);
        am.l(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.ctU, R.drawable.edittext_cursor);
            this.ctU.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.ctU, R.drawable.edittext_cursor_1);
            this.ctU.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cxG();
        am.c(this.fwN, (int) R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        if (this.mSendView.isEnabled()) {
            am.d(this.mSendView, R.color.cp_link_tip_a, 1, this.cdL);
        } else {
            am.f(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.ctU;
    }
}
