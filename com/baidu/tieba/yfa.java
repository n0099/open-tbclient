package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class yfa extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public AtListActivity b;
    public ArrayList<MetaData> c;
    public TbCheckBox.b d;
    public c e;
    public ViewGroup f;
    public boolean g;

    /* loaded from: classes8.dex */
    public interface c {
        void P0(View view2, MetaData metaData);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ yfa b;

        public a(yfa yfaVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yfaVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yfaVar;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.f(this.a)) {
                return;
            }
            this.b.b.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.b.getPageContext().getPageActivity(), this.a.getUserId(), this.a.getUserName())));
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public LinearLayout b;
        public HeadImageView c;
        public TextView d;
        public TbCheckBox e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public HeadImageView j;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948329621, "Lcom/baidu/tieba/yfa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948329621, "Lcom/baidu/tieba/yfa;");
                return;
            }
        }
        h = vi.g(TbadkApplication.getInst(), R.dimen.tbds580);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<MetaData> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public yfa(AtListActivity atListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = null;
        this.g = true;
        this.b = atListActivity;
        this.a = atListActivity.getPageContext().getContext();
        this.g = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MetaData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ArrayList<MetaData> arrayList = this.c;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.c.get(i);
        }
        return (MetaData) invokeI.objValue;
    }

    public void g(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void h(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public final b c(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = d(metaData);
            } else {
                bVar = (b) obj;
            }
            bVar.b.setOnClickListener(new a(this, metaData));
            c cVar = this.e;
            if (cVar != null) {
                cVar.P0(bVar.a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.d.setText(MeasureTextLength.fitTextLabel(metaData.getName_show(), "...", MeasureTextLength.spaceLength(h), bVar.d.getPaint(), ""));
            boolean z = true;
            if (metaData.getIsNearlyAt() == 1) {
                bVar.g.setVisibility(0);
                bVar.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f02de));
            } else if (metaData.getIsFollower() == 1) {
                bVar.g.setVisibility(0);
                bVar.g.setText(R.string.obfuscated_res_0x7f0f02dc);
            } else if (metaData.getIsMyFollower() == 1) {
                bVar.g.setVisibility(0);
                bVar.g.setText(R.string.obfuscated_res_0x7f0f02dd);
            } else {
                bVar.g.setVisibility(8);
            }
            bVar.e.setTagData(metaData);
            bVar.c.setTag(avater);
            bVar.c.setImageBitmap(null);
            if (this.g) {
                bVar.e.setVisibility(0);
            } else {
                bVar.e.setVisibility(8);
            }
            if (f(metaData)) {
                bVar.c.setDefaultResource(R.drawable.icon_at_all_user);
                avater = "";
            } else {
                bVar.c.setDefaultResource(0);
            }
            UtilHelper.showHeadImageViewBigV(bVar.c, metaData);
            bVar.c.N(avater, 12, false);
            if (this.b.B2(metaData.getUserId()) && this.b.M) {
                bVar.e.setVisibility(8);
                bVar.f.setVisibility(0);
                bVar.h.setText(R.string.obfuscated_res_0x7f0f02db);
                bVar.h.setVisibility(0);
                bVar.g.setVisibility(8);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                bVar.e.setVisibility(0);
                bVar.f.setVisibility(8);
                bVar.h.setVisibility(8);
            }
            if (!StringUtils.isNull(metaData.getGaokaoTag())) {
                bVar.i.setText(metaData.getGaokaoTag());
                bVar.i.setVisibility(0);
                bVar.j.setVisibility(0);
                if (!StringUtils.isNull(metaData.getGaokaoTagIcon())) {
                    bVar.j.N(metaData.getGaokaoTagIcon(), 10, false);
                } else {
                    bVar.j.setImageDrawable(SkinManager.getDrawable(R.drawable.kaogao_image_icon));
                }
                bVar.j.setDrawBorder(false);
            } else {
                bVar.i.setVisibility(8);
                bVar.j.setVisibility(8);
            }
            d05 layoutMode = this.b.getPageContext().getLayoutMode();
            if (skinType != 4) {
                z = false;
            }
            layoutMode.l(z);
            this.b.getPageContext().getLayoutMode().k(bVar.a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b d(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(null);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
            bVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091bd3);
            bVar.c = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.c, metaData);
            bVar.b = (LinearLayout) bVar.a.findViewById(R.id.photo_box);
            bVar.d = (TextView) bVar.a.findViewById(R.id.txt_user_name);
            TextView textView = (TextView) bVar.a.findViewById(R.id.label_user);
            bVar.g = textView;
            m75 d = m75.d(textView);
            d.w(R.color.CAM_X0108);
            d.B(R.dimen.T_X10);
            d.o(R.string.J_X04);
            d.m(R.dimen.L_X01);
            d.l(R.color.CAM_X0111);
            TextView textView2 = (TextView) bVar.a.findViewById(R.id.label_bot);
            bVar.h = textView2;
            m75 d2 = m75.d(textView2);
            d2.w(R.color.CAM_X0201);
            d2.B(R.dimen.T_X10);
            d2.o(R.string.J_X04);
            d2.m(R.dimen.L_X01);
            d2.f(R.color.CAM_X0334);
            bVar.h.setAlpha(0.7f);
            bVar.f = (ImageView) bVar.a.findViewById(R.id.bot_select_arrow);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.a.findViewById(R.id.ckb_select);
            bVar.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.e.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
            TextView textView3 = (TextView) bVar.a.findViewById(R.id.kaogao_icon);
            bVar.i = textView3;
            m75 d3 = m75.d(textView3);
            d3.C(R.string.F_X01);
            d3.B(R.dimen.T_X08);
            d3.w(R.color.CAM_X0109);
            bVar.j = (HeadImageView) bVar.a.findViewById(R.id.gaokao_img);
            TbCheckBox.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar.e.setStatedChangedListener(bVar2);
            }
            bVar.a.setTag(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public final boolean f(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, metaData)) == null) {
            if (AtSelectData.AT_ALL_FAKE_UID.equals(metaData.getUserId()) && AtSelectData.AT_ALL_FAKE_NAME.equals(metaData.getName_show()) && AtSelectData.AT_ALL_FAKE_PORTRAIT.equals(metaData.getPortrait())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (this.f == null) {
                this.f = viewGroup;
            }
            MetaData item = getItem(i);
            if (item != null) {
                if (view2 != null) {
                    obj = view2.getTag();
                } else {
                    obj = null;
                }
                bVar = c(obj, item);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return null;
            }
            return bVar.a;
        }
        return (View) invokeILL.objValue;
    }
}
