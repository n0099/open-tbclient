package com.baidu.tieba.view.widget.mediaedit.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.x0.t.h;
import c.a.x0.t.t;
import c.a.x0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.SimpleDraweeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.LocalAlbumInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MultiMediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.r0.b4.l.c.c.a> f58726a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.r0.b4.l.c.c.a> f58727b;

    /* renamed from: c  reason: collision with root package name */
    public Context f58728c;

    /* renamed from: d  reason: collision with root package name */
    public a f58729d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58730e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58731f;

    /* loaded from: classes7.dex */
    public static class MultiMediaHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MultiMediaAdapter f58732a;
        public View mBottomDot;
        public int mIndex;
        public SimpleDraweeView mMediaCover;
        public SimpleDraweeView mMediaCover1;
        public SimpleDraweeView mMediaCover2;
        public ArrayList<SimpleDraweeView> mMediaCoverList;
        public LinearLayout mMediaCoverWrap;
        public TextView mSelectedDuration;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f58733e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ MultiMediaHolder f58734f;

            public a(MultiMediaHolder multiMediaHolder, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {multiMediaHolder, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58734f = multiMediaHolder;
                this.f58733e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.r0.b4.l.c.c.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58733e == null || this.f58734f.f58732a == null || h.e(this.f58734f.f58732a.getMultiMediaItems()) || (aVar = (c.a.r0.b4.l.c.c.a) h.c(this.f58734f.f58732a.getMultiMediaItems(), this.f58734f.getAdapterPosition())) == null) {
                    return;
                }
                this.f58733e.onMultiMediaItemClick(this.f58734f.getAdapterPosition(), view, aVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiMediaHolder(View view, a aVar) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMediaCoverList = new ArrayList<>();
            this.mIndex = 0;
            this.mMediaCover = (SimpleDraweeView) view.findViewById(R.id.media_cover);
            this.mMediaCover1 = (SimpleDraweeView) view.findViewById(R.id.media_cover1);
            this.mMediaCover2 = (SimpleDraweeView) view.findViewById(R.id.media_cover2);
            this.mMediaCoverList.add(this.mMediaCover);
            this.mMediaCoverList.add(this.mMediaCover1);
            this.mMediaCoverList.add(this.mMediaCover2);
            this.mMediaCoverWrap = (LinearLayout) view.findViewById(R.id.media_cover_wrap);
            this.mSelectedDuration = (TextView) view.findViewById(R.id.tv_choose_duration);
            this.mBottomDot = view.findViewById(R.id.v_bottom_dot);
            view.setOnClickListener(new a(this, aVar));
        }

        public void setMediaAdapter(MultiMediaAdapter multiMediaAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaAdapter) == null) {
                this.f58732a = multiMediaAdapter;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void onMultiMediaItemClick(int i2, View view, c.a.r0.b4.l.c.c.a aVar);
    }

    public MultiMediaAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58730e = false;
        this.f58731f = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h.b(this.f58727b) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (h.e(this.f58727b)) {
                return -1;
            }
            return this.f58727b.get(i2).b();
        }
        return invokeI.intValue;
    }

    public List<c.a.r0.b4.l.c.c.a> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c.a.r0.b4.l.c.c.a> list = this.f58727b;
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeV.objValue;
    }

    public List<c.a.r0.b4.l.c.c.a> getMultiMediaItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58727b : (List) invokeV.objValue;
    }

    public void notifyDataChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f58731f) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        c.a.r0.b4.l.c.c.a aVar;
        String str;
        ArrayList<SimpleDraweeView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) && (aVar = (c.a.r0.b4.l.c.c.a) h.c(this.f58727b, i2)) != null && (viewHolder instanceof MultiMediaHolder)) {
            MultiMediaHolder multiMediaHolder = (MultiMediaHolder) viewHolder;
            LocalAlbumInfo a2 = aVar.a();
            if (a2 != null) {
                if ((multiMediaHolder.mMediaCover.getTag() == null || !TextUtils.equals((String) multiMediaHolder.mMediaCover.getTag(), a2.path)) && (str = a2.path) != null) {
                    multiMediaHolder.mMediaCover.setTag(str);
                    ArrayList<SimpleDraweeView> arrayList2 = multiMediaHolder.mMediaCoverList;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i3 = 0; i3 < multiMediaHolder.mMediaCoverList.size(); i3++) {
                            multiMediaHolder.mMediaCoverList.get(i3).setImageURI(Uri.fromFile(new File(a2.path)));
                        }
                    } else {
                        multiMediaHolder.mMediaCover.setImageURI(Uri.fromFile(new File(a2.path)));
                    }
                }
                multiMediaHolder.mSelectedDuration.setText(w.b((int) a2.getDurationWithSpeed()));
                multiMediaHolder.mBottomDot.setVisibility(aVar.c() ? 0 : 4);
                if (aVar.b() != 2 || (arrayList = multiMediaHolder.mMediaCoverList) == null) {
                    return;
                }
                int size = arrayList.size();
                int i4 = 1;
                if (!this.f58730e && !this.f58731f) {
                    multiMediaHolder.mMediaCoverWrap.getLayoutParams().width = ((int) t.i(R.dimen.ds100)) * size;
                    while (i4 < size) {
                        multiMediaHolder.mMediaCoverList.get(i4).setVisibility(0);
                        i4++;
                    }
                    return;
                }
                while (i4 < size) {
                    multiMediaHolder.mMediaCoverList.get(i4).setVisibility(8);
                    i4++;
                }
                multiMediaHolder.mMediaCoverWrap.getLayoutParams().width = (int) t.i(R.dimen.ds100);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            this.f58728c = viewGroup.getContext();
            if (i2 == 2) {
                MultiMediaHolder multiMediaHolder = new MultiMediaHolder(LayoutInflater.from(this.f58728c).inflate(R.layout.item_multi_media_layout, viewGroup, false), this.f58729d);
                multiMediaHolder.setMediaAdapter(this);
                return multiMediaHolder;
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void resetPlayIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (c.a.r0.b4.l.c.c.a aVar : getMultiMediaItems()) {
                aVar.d(false);
            }
        }
    }

    public void setDragMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f58730e = z;
        }
    }

    public void setLongPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f58731f = z;
        }
    }

    public void setMultiMediaItems(List<c.a.r0.b4.l.c.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f58726a = list;
            updateAdapterList();
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickLitener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f58729d = aVar;
        }
    }

    public void updateAdapterList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<c.a.r0.b4.l.c.c.a> list = this.f58727b;
            if (list == null) {
                this.f58727b = new ArrayList();
            } else {
                list.clear();
            }
            for (c.a.r0.b4.l.c.c.a aVar : this.f58726a) {
                if (aVar.b() == 1 || aVar.b() == 2) {
                    this.f58727b.add(aVar);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, viewHolder, i2, list) == null) {
            if (!h.e(list)) {
                c.a.r0.b4.l.c.c.a aVar = (c.a.r0.b4.l.c.c.a) h.c(this.f58727b, i2);
                if (viewHolder instanceof MultiMediaHolder) {
                    ((MultiMediaHolder) viewHolder).mBottomDot.setVisibility(aVar.c() ? 0 : 4);
                    return;
                }
                return;
            }
            onBindViewHolder(viewHolder, i2);
        }
    }
}
