package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.z0.i0;
import java.util.List;
/* loaded from: classes5.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22169a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f22170b;

    /* renamed from: d  reason: collision with root package name */
    public f f22172d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22171c = false;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f22173e = new a(this);

    /* loaded from: classes5.dex */
    public class a implements TextView.OnEditorActionListener {
        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            View focusSearch;
            if (i2 != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                return true;
            }
            focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22174e;

        public b(int i2) {
            this.f22174e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22172d != null) {
                WriteVoteViewAdapter.this.f22172d.a(this.f22174e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22172d != null) {
                WriteVoteViewAdapter.this.f22172d.b();
                WriteVoteViewAdapter.this.f22171c = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22177a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22178b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f22179c;

        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f22177a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f22178b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f22179c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EditText f22180a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22181b;

        /* renamed from: c  reason: collision with root package name */
        public g f22182c;

        /* loaded from: classes5.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e eVar = e.this;
                    eVar.f22180a.addTextChangedListener(eVar.f22182c);
                    return;
                }
                e eVar2 = e.this;
                eVar2.f22180a.removeTextChangedListener(eVar2.f22182c);
            }
        }

        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f22180a = (EditText) view.findViewById(R.id.vote_item);
            this.f22181b = (ImageView) view.findViewById(R.id.img_delete);
            this.f22182c = new g(this);
            this.f22180a.setOnEditorActionListener(writeVoteViewAdapter.f22173e);
        }

        public void b(int i2) {
            this.f22182c.a(i2);
            this.f22180a.setOnFocusChangeListener(new a());
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i2);
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final e f22184e;

        /* renamed from: f  reason: collision with root package name */
        public int f22185f;

        public g(e eVar) {
            this.f22184e = eVar;
        }

        public void a(int i2) {
            this.f22185f = i2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f22185f + 1);
            if (i0.d(replace) > 28) {
                WriteVoteViewAdapter.this.f22169a.showToast(String.format(WriteVoteViewAdapter.this.f22169a.getString(R.string.write_vote_toast), 14));
            }
            String m = i0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f22184e.f22180a.setText(m);
                this.f22184e.f22180a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            WriteVoteViewAdapter.this.f22172d.c(writeVoteItemData, this.f22185f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        this.f22169a = tbPageContext;
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f22169a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f22169a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f22180a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f22180a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f22180a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f22181b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f22177a, R.color.CAM_X0302);
            dVar.f22179c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f22178b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void g(f fVar) {
        this.f22172d = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WriteVoteItemData> list = this.f22170b;
        if (list == null) {
            return 0;
        }
        if (list.size() < 20) {
            return this.f22170b.size() + 1;
        }
        return 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return !h(i2) ? 1 : 2;
    }

    public final boolean h(int i2) {
        List<WriteVoteItemData> list = this.f22170b;
        return list != null && list.size() < 20 && i2 == this.f22170b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            String text = this.f22170b.get(i2).getText();
            eVar.f22180a.setHint(String.format(this.f22169a.getString(R.string.write_vote_item), Integer.valueOf(i2 + 1)));
            eVar.f22180a.setGravity(19);
            if (i2 < this.f22170b.size() - 1) {
                eVar.f22180a.setImeOptions(5);
            } else {
                eVar.f22180a.setImeOptions(1);
            }
            ImageView imageView = eVar.f22181b;
            if (this.f22170b.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new b(i2));
            eVar.b(i2);
            if (!StringUtils.isNull(text)) {
                eVar.f22180a.setText(text);
            } else {
                eVar.f22180a.setText("");
            }
            if (this.f22171c && i2 == this.f22170b.size() - 1) {
                eVar.f22180a.requestFocus();
                this.f22171c = false;
            }
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            dVar.f22177a.setText(String.format(this.f22169a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f22170b.size())));
            dVar.f22179c.setOnClickListener(new c());
        }
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new e(this, LayoutInflater.from(this.f22169a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(this.f22169a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    public void setData(List<WriteVoteItemData> list) {
        this.f22170b = list;
        notifyDataSetChanged();
    }
}
