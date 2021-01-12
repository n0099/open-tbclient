package com.baidu.tieba.videoplay.editor;

import android.content.Context;
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
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes7.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools acX;
    private int acY;
    private int akf;
    private TextView bRq;
    private boolean fAF;
    private boolean fAG;
    private boolean fAH;
    private int fAI;
    private EditText fBK;
    private LinearLayout fBO;
    private ImageView jec;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAF = false;
        this.fAG = true;
        this.fAH = true;
        this.fAI = -1;
        this.akf = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fBO = new LinearLayout(getContext());
        this.fBO.setOrientation(0);
        this.fBO.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fBO, new LinearLayout.LayoutParams(-1, -2));
        gZ(context);
        fo(context);
        fn(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void gZ(Context context) {
        this.jec = new ImageView(context);
        this.jec.setEnabled(true);
        this.jec.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.jec.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fBO.addView(this.jec, layoutParams);
    }

    private void fo(Context context) {
        this.fBK = new EditText(context);
        this.fBK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fBK.setMaxLines(4);
        this.fBK.setGravity(16);
        this.fBK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fBK.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fBK, R.drawable.edittext_cursor);
        this.fBK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fBK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fBK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fAH) {
                    VideoPlayInputContainer.this.fAH = true;
                    if (VideoPlayInputContainer.this.fAI != -1) {
                        VideoPlayInputContainer.this.fBK.setSelection(VideoPlayInputContainer.this.fAI);
                        VideoPlayInputContainer.this.fAI = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fBK.getText().toString()));
                }
                VideoPlayInputContainer.this.bRq.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dTv();
            }
        });
        this.fBK.setHint(context.getString(R.string.reply_something));
        this.fBK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fBK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fBO.addView(this.fBK, layoutParams);
    }

    private void fn(Context context) {
        this.bRq = new TextView(context);
        this.bRq.setGravity(17);
        this.bRq.setIncludeFontPadding(false);
        this.bRq.setEnabled(false);
        this.bRq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bRq.setText(R.string.send_replay);
        this.bRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fBO.addView(this.bRq, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fBK.getSelectionStart() > 0) {
                        String substring = this.fBK.getText().toString().substring(0, this.fBK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iMD.matcher(substring);
                        if (matcher.find()) {
                            this.fBK.getText().delete(this.fBK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fBK.getSelectionStart());
                            return;
                        }
                        this.fBK.getText().delete(this.fBK.getSelectionStart() - 1, this.fBK.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fBK.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fBK.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fBK.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fBK.setSelection(VideoPlayInputContainer.this.fBK.getText().length());
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
                        this.fBK.setText((CharSequence) null);
                    }
                    this.bRq.setEnabled(false);
                    dTv();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bwd() == EmotionGroupType.NET_SUG) {
                            a(uVar);
                            return;
                        } else {
                            b(uVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fBK.getText().toString();
            if (this.fAG && com.baidu.tieba.face.a.IH(obj) >= 10 && getContext() != null) {
                e.brF().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fBK);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fAF || uVar.bwd() == EmotionGroupType.LOCAL) {
            String obj = this.fBK.getText().toString();
            if (this.fAG && com.baidu.tieba.face.a.IH(obj) >= 10 && getContext() != null) {
                e.brF().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fBK);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.fBK != null) {
            this.fBK.setFocusable(true);
            this.fBK.setFocusableInTouchMode(true);
            this.fBK.requestFocus();
            l.showSoftKeyPad(getContext(), this.fBK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.akf = i;
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        ao.setViewTextColor(this.fBK, R.color.CAM_X0106, 2, i);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fBK, R.drawable.edittext_cursor);
            this.fBK.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.h(this.fBK, R.drawable.edittext_cursor_1);
            this.fBK.setHintTextColor(ao.getColor(i, R.color.CAM_X0109));
        }
        dTv();
        ao.setImageResource(this.jec, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTv() {
        if (this.bRq.isEnabled()) {
            ao.setViewTextColor(this.bRq, R.color.CAM_X0302, 1, this.akf);
        } else {
            ao.setViewTextColor(this.bRq, R.color.CAM_X0107, 1);
        }
    }

    public EditText getInputView() {
        return this.fBK;
    }
}
