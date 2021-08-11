package com.baidu.ugc.editvideo.magicmusic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class EffectType {
    public static final /* synthetic */ EffectType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EffectType DIZZINESS;
    public static final EffectType D_FAKE;
    public static final EffectType D_SKIN_NEEDLING;
    public static final EffectType FOUR_FRAME;
    public static final EffectType HALLUCINATION;
    public static final EffectType HORIZONTAL_TRANSLATION;
    public static final EffectType LR_MIRROR;
    public static final EffectType LR_TB_MIRROR;
    public static final EffectType NINE_FRAME;
    public static final EffectType NO;
    public static final EffectType NO_MATCH;
    public static final EffectType PARTICLE_BANANA;
    public static final EffectType PARTICLE_BOMB;
    public static final EffectType PARTICLE_FLAME;
    public static final EffectType PARTICLE_FLASH;
    public static final EffectType PARTICLE_HEART;
    public static final EffectType PARTICLE_MAGICSTICK;
    public static final EffectType PARTICLE_PINKSTAR;
    public static final EffectType PARTICLE_SAKULA;
    public static final EffectType PARTICLE_SNOW;
    public static final EffectType PARTICLE_SNOWFLAKE;
    public static final EffectType ROTATE;
    public static final EffectType SCALE_BIG;
    public static final EffectType SIX_FRAME;
    public static final EffectType SOUL_OUT;
    public static final EffectType TB_MIRROR;
    public static final EffectType THREE_FRAME;
    public static final EffectType TIME_REPEAT;
    public static final EffectType TIME_REVERSE;
    public static final EffectType TRANSITION_ALPHA_ONE;
    public static final EffectType TRANSITION_ALPHA_REPEAT;
    public static final EffectType TRANSITION_ALPHA_TWO;
    public static final EffectType TRANSITION_BIG_SMALL_SCREEN;
    public static final EffectType TRANSITION_BOTH_SCREEN;
    public static final EffectType TRANSITION_ONE;
    public static final EffectType TRANSITION_SHADOW;
    public static final EffectType TRANSITION_TRAN_LEFT;
    public static final EffectType TRANSITION_TRAN_REPEAT;
    public static final EffectType TRANSITION_TRAN_RIGHT;
    public static final EffectType TRANSITION_TWO;
    public static final EffectType VERTICAL_TRANSLATION;
    public static final EffectType WAGGLE;
    public static final EffectType WHITE_BLACK;
    public transient /* synthetic */ FieldHolder $fh;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(365695875, "Lcom/baidu/ugc/editvideo/magicmusic/EffectType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(365695875, "Lcom/baidu/ugc/editvideo/magicmusic/EffectType;");
                return;
            }
        }
        NO_MATCH = new EffectType("NO_MATCH", 0, 0);
        NO = new EffectType("NO", 1, 0);
        TRANSITION_TRAN_LEFT = new EffectType("TRANSITION_TRAN_LEFT", 2, 20);
        TRANSITION_TRAN_RIGHT = new EffectType("TRANSITION_TRAN_RIGHT", 3, 21);
        TRANSITION_TRAN_REPEAT = new EffectType("TRANSITION_TRAN_REPEAT", 4, 22);
        TRANSITION_ALPHA_ONE = new EffectType("TRANSITION_ALPHA_ONE", 5, 23);
        TRANSITION_ALPHA_TWO = new EffectType("TRANSITION_ALPHA_TWO", 6, 24);
        TRANSITION_ALPHA_REPEAT = new EffectType("TRANSITION_ALPHA_REPEAT", 7, 25);
        TRANSITION_BOTH_SCREEN = new EffectType("TRANSITION_BOTH_SCREEN", 8, 26);
        TRANSITION_ONE = new EffectType("TRANSITION_ONE", 9, 27);
        TRANSITION_TWO = new EffectType("TRANSITION_TWO", 10, 28);
        TRANSITION_SHADOW = new EffectType("TRANSITION_SHADOW", 11, 29);
        TRANSITION_BIG_SMALL_SCREEN = new EffectType("TRANSITION_BIG_SMALL_SCREEN", 12, 30);
        HORIZONTAL_TRANSLATION = new EffectType("HORIZONTAL_TRANSLATION", 13, -1);
        VERTICAL_TRANSLATION = new EffectType("VERTICAL_TRANSLATION", 14, -2);
        ROTATE = new EffectType("ROTATE", 15, -3);
        SOUL_OUT = new EffectType("SOUL_OUT", 16, 10);
        SCALE_BIG = new EffectType("SCALE_BIG", 17, 11);
        WHITE_BLACK = new EffectType("WHITE_BLACK", 18, 12);
        NINE_FRAME = new EffectType("NINE_FRAME", 19, 13);
        THREE_FRAME = new EffectType("THREE_FRAME", 20, 14);
        FOUR_FRAME = new EffectType("FOUR_FRAME", 21, 15);
        SIX_FRAME = new EffectType("SIX_FRAME", 22, 16);
        D_FAKE = new EffectType("D_FAKE", 23, 17);
        D_SKIN_NEEDLING = new EffectType("D_SKIN_NEEDLING", 24, 18);
        LR_MIRROR = new EffectType("LR_MIRROR", 25, 19);
        TB_MIRROR = new EffectType("TB_MIRROR", 26, 101);
        LR_TB_MIRROR = new EffectType("LR_TB_MIRROR", 27, 102);
        WAGGLE = new EffectType("WAGGLE", 28, 103);
        DIZZINESS = new EffectType("DIZZINESS", 29, 104);
        HALLUCINATION = new EffectType("HALLUCINATION", 30, 105);
        TIME_REPEAT = new EffectType("TIME_REPEAT", 31, 1);
        TIME_REVERSE = new EffectType("TIME_REVERSE", 32, 2);
        PARTICLE_SNOWFLAKE = new EffectType("PARTICLE_SNOWFLAKE", 33, 41);
        PARTICLE_HEART = new EffectType("PARTICLE_HEART", 34, 42);
        PARTICLE_BOMB = new EffectType("PARTICLE_BOMB", 35, 44);
        PARTICLE_SAKULA = new EffectType("PARTICLE_SAKULA", 36, 46);
        PARTICLE_SNOW = new EffectType("PARTICLE_SNOW", 37, 47);
        PARTICLE_BANANA = new EffectType("PARTICLE_BANANA", 38, 49);
        PARTICLE_FLAME = new EffectType("PARTICLE_FLAME", 39, 50);
        PARTICLE_PINKSTAR = new EffectType("PARTICLE_PINKSTAR", 40, 51);
        PARTICLE_MAGICSTICK = new EffectType("PARTICLE_MAGICSTICK", 41, 52);
        EffectType effectType = new EffectType("PARTICLE_FLASH", 42, 53);
        PARTICLE_FLASH = effectType;
        $VALUES = new EffectType[]{NO_MATCH, NO, TRANSITION_TRAN_LEFT, TRANSITION_TRAN_RIGHT, TRANSITION_TRAN_REPEAT, TRANSITION_ALPHA_ONE, TRANSITION_ALPHA_TWO, TRANSITION_ALPHA_REPEAT, TRANSITION_BOTH_SCREEN, TRANSITION_ONE, TRANSITION_TWO, TRANSITION_SHADOW, TRANSITION_BIG_SMALL_SCREEN, HORIZONTAL_TRANSLATION, VERTICAL_TRANSLATION, ROTATE, SOUL_OUT, SCALE_BIG, WHITE_BLACK, NINE_FRAME, THREE_FRAME, FOUR_FRAME, SIX_FRAME, D_FAKE, D_SKIN_NEEDLING, LR_MIRROR, TB_MIRROR, LR_TB_MIRROR, WAGGLE, DIZZINESS, HALLUCINATION, TIME_REPEAT, TIME_REVERSE, PARTICLE_SNOWFLAKE, PARTICLE_HEART, PARTICLE_BOMB, PARTICLE_SAKULA, PARTICLE_SNOW, PARTICLE_BANANA, PARTICLE_FLAME, PARTICLE_PINKSTAR, PARTICLE_MAGICSTICK, effectType};
    }

    public EffectType(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = i3;
    }

    public static EffectType findType(int i2) {
        InterceptResult invokeI;
        EffectType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (EffectType effectType : values()) {
                if (effectType.getType() == i2) {
                    return effectType;
                }
            }
            return NO_MATCH;
        }
        return (EffectType) invokeI.objValue;
    }

    public static EffectType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (EffectType) Enum.valueOf(EffectType.class, str) : (EffectType) invokeL.objValue;
    }

    public static EffectType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (EffectType[]) $VALUES.clone() : (EffectType[]) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : invokeV.intValue;
    }
}
