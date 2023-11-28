package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class o6b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PendantData> a;
    public BdPageContext b;
    public b c;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view2, int i, PendantData pendantData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o6b a;

        public a(o6b o6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o6bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c != null) {
                c cVar = (c) view2.getTag();
                if (!(cVar.b.getTag() instanceof Integer)) {
                    return;
                }
                Integer num = (Integer) cVar.b.getTag();
                if (this.a.a.size() <= num.intValue()) {
                    return;
                }
                this.a.c.a(view2, num.intValue(), (PendantData) this.a.a.get(num.intValue()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public ProgressBar c;

        public c(o6b o6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public o6b(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bdPageContext;
    }

    public void c(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PendantData> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0574, (ViewGroup) null);
                cVar = new c(this);
                cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090852);
                cVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c69);
                cVar.c = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091c6c);
                cVar.b.setDefaultBgResource(R.color.transparent);
                cVar.b.setDefaultResource(R.color.CAM_X0101);
                view2.setOnClickListener(new a(this));
                view2.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                view2.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
            }
            PendantData pendantData = this.a.get(i);
            if (pendantData != null) {
                cVar.b.setTag(Integer.valueOf(i));
                int i2 = pendantData.pendantType;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                cVar.a.setVisibility(8);
                                cVar.b.setVisibility(0);
                                cVar.c.setVisibility(8);
                                cVar.b.startLoad(pendantData.img, 10, false);
                            } else {
                                cVar.a.setVisibility(0);
                                cVar.b.setVisibility(8);
                                cVar.c.setVisibility(8);
                                cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                                cVar.a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                                cVar.a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                            }
                        } else {
                            cVar.a.setVisibility(0);
                            cVar.b.setVisibility(8);
                            cVar.c.setVisibility(8);
                            cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                            cVar.a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                            cVar.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
                        }
                    } else {
                        cVar.a.setVisibility(0);
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                        cVar.a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                        cVar.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
                    }
                } else {
                    cVar.a.setVisibility(0);
                    cVar.b.setVisibility(8);
                    cVar.c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    cVar.a.setText("No");
                    cVar.a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
