package com.baidu.tieba;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.u36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public Runnable B;
    public View.OnClickListener C;
    public Context a;
    public TbPageContext b;
    public a55 c;
    public ViewGroup d;
    public NegativeFeedBackData e;
    public SparseArray<String> f;
    public List<u36.b> g;
    public u36 h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public TextView m;
    public TBSpecificationBtn n;
    public ea5 o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public View s;
    public View t;
    public NEGFeedBackView.NEGFeedbackEventCallback u;
    public boolean v;
    public boolean w;
    public boolean x;
    public CustomMessageListener y;
    public CompoundButton.OnCheckedChangeListener z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w36 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w36 w36Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w36Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w36Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w36 a;

        public b(w36 w36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w36Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.u != null) {
                    this.a.u.onCheckedChanged(this.a.e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof u36.b) {
                    u36.b bVar = (u36.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.g.contains(bVar)) {
                            this.a.g.add(bVar);
                        }
                    } else {
                        this.a.g.remove(bVar);
                    }
                }
                if (!ListUtils.isEmpty(this.a.g)) {
                    SafeHandler.getInst().removeCallbacks(this.a.B);
                    SafeHandler.getInst().postDelayed(this.a.B, 500L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w36 a;

        public c(w36 w36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w36 a;

        public d(w36 w36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w36Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w36 a;

        public e(w36 w36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.m();
        }
    }

    public w36(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.j = 3;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = new a(this, 2001304);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new d(this);
        this.C = new e(this);
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        l();
    }

    public void p(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nEGFeedbackEventCallback) == null) {
            this.u = nEGFeedbackEventCallback;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h.m(z);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public final void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.j) {
            EMManager.from(this.d).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
            this.j = skinType;
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!ListUtils.isEmpty(this.g)) {
                StringBuilder sb = new StringBuilder();
                for (u36.b bVar : this.g) {
                    if (bVar != null) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(bVar.c);
                    }
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.a == null) {
            return;
        }
        View k = k();
        if (k != null && k.getParent() != null) {
            ((ViewGroup) k.getParent()).removeView(k);
        }
        g();
        this.c = new a55(this.b);
        n();
        this.c.setContentView(k);
        this.c.show();
        TbPageContext tbPageContext = this.b;
        if (tbPageContext != null) {
            tbPageContext.registerListener(this.y);
        }
        NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback = this.u;
        if (nEGFeedbackEventCallback != null) {
            nEGFeedbackEventCallback.onNEGFeedbackWindowShow(this.e);
        }
        this.i = true;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a55 a55Var = this.c;
            if (a55Var != null) {
                a55Var.dismiss();
                this.c = null;
            }
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.i || this.g.size() == 0) {
            return;
        }
        this.g.clear();
    }

    public final JSONObject j(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.e != null && arrayList != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (!ListUtils.isEmpty(this.g)) {
                    for (u36.b bVar : this.g) {
                        if (bVar != null) {
                            arrayList.add(Integer.valueOf(bVar.b));
                            if (sb.length() != 0) {
                                sb.append(",");
                            }
                            sb.append(String.valueOf(bVar.b));
                            if (sb2.length() != 0) {
                                sb2.append(",");
                            }
                            sb2.append(bVar.d);
                        }
                    }
                }
                try {
                    jSONObject.put("tid", this.e.getTid());
                    if (sb.length() != 0) {
                        jSONObject.put("dislike_ids", sb.toString());
                    }
                    jSONObject.put("fid", this.e.getFid());
                    jSONObject.put("click_time", System.currentTimeMillis());
                    if (!StringUtils.isNull(this.e.getType())) {
                        jSONObject.put("type", this.e.getType());
                    }
                    if (this.e.getTopicID() != 0) {
                        jSONObject.put("topic_id", this.e.getTopicID());
                    }
                    jSONObject.put("extra", sb2.toString());
                    if (this.x) {
                        str = "client_videomiddle";
                    } else {
                        str = "client_videotab";
                    }
                    jSONObject.put("dislike_from", str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final View k() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.d = viewGroup;
                this.m = (TextView) viewGroup.findViewById(R.id.head_text);
                this.n = (TBSpecificationBtn) this.d.findViewById(R.id.uninterested_btn);
                ea5 ea5Var = new ea5();
                this.o = ea5Var;
                ea5Var.u(R.color.CAM_X0304);
                this.n.setConfig(this.o);
                this.n.setOnClickListener(this.C);
                this.n.setText(this.a.getResources().getString(R.string.not_interested));
                this.n.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.d;
                int i2 = this.k;
                if (this.w) {
                    i = 0;
                } else {
                    i = this.l;
                }
                viewGroup2.setPadding(i2, 0, i2, i);
            }
            View h = this.h.h();
            if (h != null && h.getParent() == null) {
                this.d.addView(h);
            }
            if (this.p == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.p = linearLayout;
                this.s = linearLayout.findViewById(R.id.top_line);
                this.r = (TextView) this.p.findViewById(R.id.dialog_bottom_cancel_button);
                this.q = (TextView) this.p.findViewById(R.id.dialog_bottom_certain_button);
                View findViewById = this.p.findViewById(R.id.middle_line);
                this.t = findViewById;
                findViewById.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setOnClickListener(this.A);
                this.d.addView(this.p);
            }
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = BdUtilHelper.getDimens(this.a, R.dimen.M_W_X005);
            this.l = BdUtilHelper.getDimens(this.a, R.dimen.M_H_X007);
            u36 u36Var = new u36(this.b.getPageActivity());
            this.h = u36Var;
            u36Var.o(this.z);
            this.h.n(true);
            this.h.m(true);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.e != null && this.c != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject j = j(arrayList);
            if (this.v) {
                if (!StringUtils.isNull(this.e.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, this.b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, j);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, this.b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, j);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
            }
            h();
            String string = this.a.getResources().getString(R.string.reduce_related_thread_recommend);
            if (j != null && "7".equals(j.optString("dislike_ids"))) {
                string = this.a.getResources().getString(R.string.forbidden_forum_success1);
            }
            BdUtilHelper.showToast(this.a, string);
            NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback = this.u;
            if (nEGFeedbackEventCallback != null) {
                nEGFeedbackEventCallback.onNEGFeedbackConfirm(arrayList, i(), this.e);
            }
        }
    }

    public void o(NegativeFeedBackData negativeFeedBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, negativeFeedBackData) != null) || negativeFeedBackData == null) {
            return;
        }
        this.e = negativeFeedBackData;
        SparseArray<String> feedBackReasonMap = negativeFeedBackData.getFeedBackReasonMap();
        this.f = feedBackReasonMap;
        if (feedBackReasonMap != null && feedBackReasonMap.size() > 9) {
            for (int size = this.f.size() - 1; size >= 9; size--) {
                this.f.removeAt(size);
            }
        }
        this.h.j(negativeFeedBackData);
    }
}
