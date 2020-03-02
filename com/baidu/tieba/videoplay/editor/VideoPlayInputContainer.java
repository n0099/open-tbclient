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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes11.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools FO;
    private int FP;
    private int Ni;
    private boolean dxZ;
    private EditText dyD;
    private LinearLayout dyH;
    private boolean dya;
    private boolean dyb;
    private int dyc;
    private ImageView gre;
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
        this.dxZ = false;
        this.dya = true;
        this.dyb = true;
        this.dyc = -1;
        this.Ni = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.dyH = new LinearLayout(getContext());
        this.dyH.setOrientation(0);
        this.dyH.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dyH, new LinearLayout.LayoutParams(-1, -2));
        fF(context);
        dZ(context);
        dY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fF(Context context) {
        this.gre = new ImageView(context);
        this.gre.setEnabled(true);
        this.gre.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.gre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.dyH.addView(this.gre, layoutParams);
    }

    private void dZ(Context context) {
        this.dyD = new EditText(context);
        this.dyD.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyD.setMaxLines(4);
        this.dyD.setGravity(16);
        this.dyD.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyD.setBackgroundResource(R.color.common_color_10022);
        e(this.dyD, R.drawable.edittext_cursor);
        this.dyD.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.dyb) {
                    VideoPlayInputContainer.this.dyb = true;
                    if (VideoPlayInputContainer.this.dyc != -1) {
                        VideoPlayInputContainer.this.dyD.setSelection(VideoPlayInputContainer.this.dyc);
                        VideoPlayInputContainer.this.dyc = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.dyD.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cTm();
            }
        });
        this.dyD.setHint(context.getString(R.string.reply_something));
        this.dyD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.dyD.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.dyH.addView(this.dyD, layoutParams);
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

    private void dY(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.mSendView.setText(R.string.send_replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.dyH.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dyD.getSelectionStart() > 0) {
                        String substring = this.dyD.getText().toString().substring(0, this.dyD.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gau.matcher(substring);
                        if (matcher.find()) {
                            this.dyD.getText().delete(this.dyD.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyD.getSelectionStart());
                            return;
                        }
                        this.dyD.getText().delete(this.dyD.getSelectionStart() - 1, this.dyD.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.dyD.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyD.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.dyD.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.dyD.setSelection(VideoPlayInputContainer.this.dyD.getText().length());
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
                        this.dyD.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cTm();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.aJw() == EmotionGroupType.NET_SUG) {
                            a(qVar);
                            return;
                        } else {
                            b(qVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyD.getText().toString();
            if (this.dya && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyD);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dxZ || qVar.aJw() == EmotionGroupType.LOCAL) {
            String obj = this.dyD.getText().toString();
            if (this.dya && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyD);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dyD != null) {
            this.dyD.setFocusable(true);
            this.dyD.setFocusableInTouchMode(true);
            this.dyD.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyD);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.Ni = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dyD, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dyD, R.drawable.edittext_cursor);
            this.dyD.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.dyD, R.drawable.edittext_cursor_1);
            this.dyD.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cTm();
        am.setImageResource(this.gre, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTm() {
        if (this.mSendView.isEnabled()) {
            am.setViewTextColor(this.mSendView, R.color.cp_link_tip_a, 1, this.Ni);
        } else {
            am.setViewTextColor(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.dyD;
    }
}
