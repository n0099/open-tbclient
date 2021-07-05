package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ImageProblemView extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageProblemActivity f17997a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17998b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f17999c;

    /* renamed from: d  reason: collision with root package name */
    public View f18000d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18001e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18002f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageProblemActivity, imageProblemAssistant};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17997a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f18000d = this.f17997a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f17997a.findViewById(R.id.view_navigation_bar);
        this.f17998b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17998b.setTitleText(this.f17997a.getPageContext().getString(R.string.image_problem));
        this.f17999c = (ScrollView) this.f17997a.findViewById(R.id.scrollView);
        Button button = (Button) this.f17997a.findViewById(R.id.check_btn);
        this.f18001e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f17997a.getPageContext().getPageActivity());
        this.f18002f = linearLayout;
        linearLayout.setOrientation(1);
        this.f17999c.addView(this.f18002f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f17987d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f17997a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f17989a);
            this.f18002f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = 0; i2 < this.f18002f.getChildCount(); i2++) {
                View childAt = this.f18002f.getChildAt(i2);
                if (childAt instanceof ImageProblemItemView) {
                    ((ImageProblemItemView) childAt).setStatus(1);
                }
            }
        }
    }

    public Button getCheckButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18001e : (Button) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f17997a.getLayoutMode().k(i2 == 1);
            this.f17997a.getLayoutMode().j(this.f18000d);
            this.f17998b.onChangeSkinType(getPageContext(), i2);
        }
    }

    public void setValue(int i2, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, arrayList) == null) {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                View childAt = this.f18002f.getChildAt(i3);
                if (childAt instanceof ImageProblemItemView) {
                    ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                    imageProblemItemView.setStatus(1);
                    imageProblemItemView.displayArrow();
                    if (arrayList.get(i3).f17990b == 0) {
                        imageProblemItemView.setHelpText("");
                        imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                    } else {
                        imageProblemItemView.setHelpText(arrayList.get(i3).f17991c);
                        imageProblemItemView.setArrowImg(R.drawable.icon_error);
                    }
                }
            }
            if (i2 < this.f18002f.getChildCount()) {
                View childAt2 = this.f18002f.getChildAt(i2);
                if (childAt2 instanceof ImageProblemItemView) {
                    ((ImageProblemItemView) childAt2).setStatus(2);
                }
            }
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i2 = 0; i2 < this.f18002f.getChildCount(); i2++) {
                View childAt = this.f18002f.getChildAt(i2);
                if (childAt instanceof ImageProblemItemView) {
                    ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                    imageProblemItemView.setStatus(3);
                    imageProblemItemView.hideArrow();
                    imageProblemItemView.setHelpText("");
                }
            }
        }
    }
}
