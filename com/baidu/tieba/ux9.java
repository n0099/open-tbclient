package com.baidu.tieba;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personPolymeric.jvbao.ReportThemeActivity;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ux9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public ReportThemeActivity b;
    public ArrayList<cn> c;
    public ViewGroup d;
    public ArrayList<String> e;
    public int f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ThreadData c;
        public final /* synthetic */ ux9 d;

        /* loaded from: classes8.dex */
        public class a extends Thread {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Message message = new Message();
                    message.what = 1;
                    if (this.a.d.f > this.a.d.e.size()) {
                        message.arg1 = this.a.d.f;
                        this.a.d.f = 0;
                    } else {
                        message.arg1 = this.a.d.e.size();
                    }
                    this.a.d.b.u.sendMessage(message);
                }
            }
        }

        public b(ux9 ux9Var, c cVar, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var, cVar, str, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ux9Var;
            this.a = cVar;
            this.b = str;
            this.c = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (((Boolean) view2.getTag()).booleanValue()) {
                    if (this.d.e.size() < 10) {
                        this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                        this.d.e.add(this.b);
                        TiebaStatic.log(new StatisticItem("c14574").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.c.getFid()).param("fname", this.c.getForum_name()).param("tid", this.c.getTid()));
                    } else {
                        ux9 ux9Var = this.d;
                        ux9Var.f = ux9Var.e.size() + 1;
                    }
                } else {
                    this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                    this.d.e.remove(this.b);
                }
                new a(this).start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ ux9 c;

        public a(ux9 ux9Var, int i, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var, Integer.valueOf(i), threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ux9Var;
            this.a = i;
            this.b = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == 40) {
                    this.c.i(this.b);
                } else {
                    this.c.h(this.b);
                }
                TiebaStatic.log(new StatisticItem("c14575").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.b.getFid()).param("fname", this.b.getForum_name()).param("tid", this.b.getTid()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public LinearLayout b;
        public TbImageView c;
        public TextView d;
        public ImageView e;
        public LinearLayout f;

        public c(ux9 ux9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(ux9 ux9Var, a aVar) {
            this(ux9Var);
        }
    }

    public ux9(ReportThemeActivity reportThemeActivity, ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reportThemeActivity, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = 0;
        this.b = reportThemeActivity;
        this.a = reportThemeActivity.getPageContext().getContext();
        this.c = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: g */
    public cn getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.c.get(i);
        }
        return (cn) invokeI.objValue;
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) != null) || threadData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = threadData.getTid();
        arrayList.add(videoItemData);
        new VideoRecommentPlayActivityConfig(this.a, arrayList, null, null).start();
    }

    public void j(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.c = arrayList;
            notifyDataSetChanged();
        }
    }

    public final c e(Object obj, cn cnVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, cnVar)) == null) {
            if (obj == null) {
                return f(cnVar);
            }
            return (c) obj;
        }
        return (c) invokeLL.objValue;
    }

    public final c f(cn cnVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cnVar)) == null) {
            c cVar = new c(this, null);
            if (cnVar instanceof up6) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0886, (ViewGroup) null);
                cVar.a = inflate;
                cVar.b = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09155b);
                cVar.c = (TbImageView) cVar.a.findViewById(R.id.obfuscated_res_0x7f0907f6);
                cVar.d = (TextView) cVar.a.findViewById(R.id.obfuscated_res_0x7f0925d7);
                cVar.e = (ImageView) cVar.a.findViewById(R.id.obfuscated_res_0x7f0906e2);
                cVar.f = (LinearLayout) cVar.a.findViewById(R.id.obfuscated_res_0x7f0906e3);
                EMManager.from(cVar.a).setBorderColor(R.color.CAM_X0101);
                EMManager.from(cVar.b).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
                EMManager.from(cVar.d).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X07);
                ThreadData threadData = ((up6) cnVar).getThreadData();
                String tid = threadData.getTid();
                cVar.d.setText(threadData.getTitle());
                if (threadData != null) {
                    if (threadData.isShareThread && (str = threadData.originalThreadData.c) != null) {
                        cVar.c.startLoad(str, 33, false);
                    } else if (threadData.isRealVideoThread() && threadData.getThreadVideoInfo().thumbnail_url != null) {
                        cVar.c.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 33, false);
                    } else if (threadData.threadType == 0 && threadData.getMedias().size() != 0) {
                        cVar.c.startLoad(threadData.getMedias().get(0).small_pic_url, 33, false);
                    } else {
                        cVar.c.startLoad(String.valueOf((int) R.drawable.icon_empty_coverimg), 24, false);
                    }
                }
                cVar.b.setOnClickListener(new a(this, threadData.getThreadType(), threadData));
                this.e = this.b.I1();
                boolean z = false;
                for (int i = 0; i < this.e.size(); i++) {
                    if (tid.equals(this.e.get(i))) {
                        z = true;
                    }
                }
                cVar.f.setTag(Boolean.valueOf(z));
                if (((Boolean) cVar.f.getTag()).booleanValue()) {
                    cVar.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else {
                    cVar.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
                cVar.f.setOnClickListener(new b(this, cVar, tid, threadData));
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<cn> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (this.d == null) {
                this.d = viewGroup;
            }
            cn item = getItem(i);
            if (item != null) {
                if (view2 != null) {
                    obj = view2.getTag();
                } else {
                    obj = null;
                }
                cVar = e(obj, item);
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return null;
            }
            return cVar.a;
        }
        return (View) invokeILL.objValue;
    }

    public void h(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, threadData) != null) || threadData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(TbadkCoreApplication.getInst().getContext()).createNormalCfg(threadData.getTid(), null, null)));
    }
}
